package com.haiyu.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haiyu.manager.common.utils.SnowflakeIdUtils;
import com.haiyu.manager.dao.ServeOfBarberMapper;
import com.haiyu.manager.pojo.MVPMember;
import com.haiyu.manager.pojo.ServeOfBarber;
import com.haiyu.manager.pojo.example.BaseAdminUserExample;
import com.haiyu.manager.response.PageDataResult;
import com.haiyu.manager.service.AdminUserService;
import com.haiyu.manager.common.utils.DigestUtils;
import com.haiyu.manager.dto.AdminUserDTO;
import com.haiyu.manager.pojo.BaseAdminUser;
import com.haiyu.manager.dao.BaseAdminUserMapper;
import com.haiyu.manager.dto.UserSearchDTO;
import com.haiyu.manager.common.utils.DateUtils;
import lombok.Data;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Title: AdminUserServiceImpl
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/11/21 11:04
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseAdminUserMapper baseAdminUserMapper;
    @Autowired
    private ServeOfBarberMapper serveOfBarberMapper;

    @Override
    public List<BaseAdminUser> getAllStores() {
        BaseAdminUserExample baseAdminUserExample = new BaseAdminUserExample();
        baseAdminUserExample.createCriteria().andIsShopEqualTo(1);
        List<BaseAdminUser> baseAdminUsers = baseAdminUserMapper.selectByExample(baseAdminUserExample);
        return baseAdminUsers;
    }

    @Override
    public List<BaseAdminUser> listMembersInServe(int sid,int serveId) {
        List<BaseAdminUser> baseAdminUsers = baseAdminUserMapper.listMemberInServe(sid,serveId);
        return baseAdminUsers;
    }

    @Override
    public PageDataResult getUserList(UserSearchDTO userSearch, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        List<AdminUserDTO> baseAdminUsers = baseAdminUserMapper.getUserList(userSearch);
        PageHelper.startPage(pageNum, pageSize);

        if(baseAdminUsers.size() != 0){
            PageInfo<AdminUserDTO> pageInfo = new PageInfo<>(baseAdminUsers);
            pageDataResult.setList(baseAdminUsers);
            pageDataResult.setTotals((int) pageInfo.getTotal());
        }

        return pageDataResult;
    }


    @Override
    public Map<String,Object> addUser(BaseAdminUser user) {
        Map<String,Object> data = new HashMap();
        try {
            BaseAdminUser old = baseAdminUserMapper.getUserByUserName(user.getSysUserName(),Optional.ofNullable(user.getSid()).orElse(0));
            if(old != null){
                data.put("code",0);
                data.put("msg","用户名已存在！");
                logger.error("用户[新增]，结果=用户名已存在！");
                return data;
            }
            String phone = user.getUserPhone();
            if(phone.length() != 11){
                data.put("code",0);
                data.put("msg","手机号位数不对！");
                logger.error("置用户[新增或更新]，结果=手机号位数不对！");
                return data;
            }
            String username = user.getSysUserName();
            if(user.getSysUserPwd() == null){
                String password = DigestUtils.Md5(username,"123456");
                user.setSysUserPwd(password);
            }else{
                String password = DigestUtils.Md5(username,user.getSysUserPwd());
                user.setSysUserPwd(password);
            }
            if (Optional.ofNullable(user.getIsShop()).orElse(-1) == 1){
                user.setSid((int) new SnowflakeIdUtils().nextId());
            }else{
                BaseAdminUser principal = (BaseAdminUser) SecurityUtils.getSubject().getPrincipal();
                user.setSid(principal.getSid());
            }
            user.setRegTime(DateUtils.getCurrentDate());
            user.setUserStatus(1);
            int result = baseAdminUserMapper.insert(user);

            ServeOfBarber serveOfBarber = new ServeOfBarber();
            serveOfBarber.setBarberId(user.getId());
            serveOfBarberMapper.insertSelective(serveOfBarber);
            if(result == 0){
                data.put("code",0);
                data.put("msg","新增失败！");
                logger.error("用户[新增]，结果=新增失败！");
                return data;
            }
            data.put("code",1);
            data.put("msg","新增成功！");
            logger.info("用户[新增]，结果=新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户[新增]异常！", e);
            return data;
        }
        return data;
    }


    @Override
    public Map <String, Object> updateUser(BaseAdminUser user) {
        Map<String,Object> data = new HashMap();
        Integer id = user.getId();
        BaseAdminUser old = baseAdminUserMapper.getUserByUserName(user.getSysUserName(),id);
        if(old != null){
            data.put("code",0);
            data.put("msg","用户名已存在！");
            logger.error("用户[更新]，结果=用户名已存在！");
            return data;
        }
        String username = user.getSysUserName();
        if(user.getSysUserPwd() != null){
            String password = DigestUtils.Md5(username,user.getSysUserPwd());
            user.setSysUserPwd(password);
        }

        int result = baseAdminUserMapper.updateByPrimaryKeySelective(user);
        if(result == 0){
            data.put("code",0);
            data.put("msg","更新失败！");
            logger.error("用户[更新]，结果=更新失败！");
            return data;
        }
        data.put("code",1);
        data.put("msg","更新成功！");
        logger.info("用户[更新]，结果=更新成功！");
        return data;
    }

    @Override
    public BaseAdminUser getUserById(Integer id) {
        return baseAdminUserMapper.selectByPrimaryKey(id);
    }


    @Override
    public Map <String, Object> delUser(Integer id,Integer status) {
        Map<String, Object> data = new HashMap<>();
        try {
            // 删除用户
            int result = baseAdminUserMapper.updateUserStatus(id,status);
            if(result == 0){
                data.put("code",0);
                data.put("msg","删除用户失败");
                logger.error("删除用户失败");
                return data;
            }
            data.put("code",1);
            data.put("msg","删除用户成功");
            logger.info("删除用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除用户异常！", e);
        }
        return data;
    }

    @Override
    public Map <String, Object> recoverUser(Integer id, Integer status) {
        Map<String, Object> data = new HashMap<>();
        try {
            int result = baseAdminUserMapper.updateUserStatus(id,status);
            if(result == 0){
                data.put("code",0);
                data.put("msg","恢复用户失败");
            }
            data.put("code",1);
            data.put("msg","恢复用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("恢复用户异常！", e);
        }
        return data;
    }

    @Override
    public List<BaseAdminUser> selectWholeStore(Integer sid) {
        BaseAdminUserExample baseAdminUserExample = new BaseAdminUserExample();
        BaseAdminUserExample.Criteria criteria = baseAdminUserExample.createCriteria();
        criteria.andSidEqualTo(sid);
        List<BaseAdminUser> wholeStore = baseAdminUserMapper.selectByExample(baseAdminUserExample);
        return wholeStore;
    }

    @Data
    //基本类型入参不会发生改变，所以需要类
    class MVPCriterion{
        final static String mvpDealTitle = "万人迷";
        final static String mvpBnfTitle = "招财猫";
        final static String mvpGoodCmtTitle = "上帝的宠儿";
        final String mvpDealKey = "mvpDeal";
        final String mvpBnfKey = "mvpBnf";
        final String mvpGoodCmtKey = "mvpGoodCmt";
        private int curDealIndex = 0;
        private int curMvpBnfIndex = 0;
        private int curGoodCmtIndex = 0;
    }
    @Override
    public List<MVPMember> selectMVPMembers(Integer sid) {
        MVPCriterion mvpCriterion = new MVPCriterion();
        String mvpDealKey = mvpCriterion.getMvpDealKey();
        String mvpBnfKey = mvpCriterion.getMvpBnfKey();
        String mvpGoodCmtKey = mvpCriterion.getMvpGoodCmtKey();

        List<MVPMember> mvpMembers = baseAdminUserMapper.selectMVPMembers(sid);
        Map<String,Map<Integer,Integer>> mvpDataCache = new HashMap<>();
        //Map<下标,数值>
        Map<Integer,Integer> initMvpInfo = new HashMap<>();
        initMvpInfo.put(0,0);
        mvpDataCache.put(mvpDealKey,initMvpInfo);
        mvpDataCache.put(mvpBnfKey,initMvpInfo);
        mvpDataCache.put(mvpGoodCmtKey,initMvpInfo);

        //记录数组中最大数值的下标，并更新最大值
        if (!mvpMembers.isEmpty()){
            for (int i = 0; i < mvpMembers.size(); i++) {
                MVPMember mvpMember = mvpMembers.get(i);
                int finalDeal = mvpMember.getFinDeal();
                int totalBenefit = mvpMember.getTotalBenefit();
                int goodComment = mvpMember.getGoodComment();
                mvpCriterion.setCurDealIndex(getCurMvpIndex(mvpDealKey, mvpCriterion.getCurDealIndex(), mvpDataCache, i, finalDeal));
                mvpCriterion.setCurMvpBnfIndex(getCurMvpIndex(mvpBnfKey, mvpCriterion.getCurMvpBnfIndex(), mvpDataCache, i, totalBenefit));
                mvpCriterion.setCurGoodCmtIndex(getCurMvpIndex(mvpGoodCmtKey, mvpCriterion.getCurGoodCmtIndex(), mvpDataCache, i, goodComment));
            }
            int mvpDealIndex = (int) mvpDataCache.get(mvpDealKey).keySet().toArray()[0];
            int mvpBnfIndex = (int) mvpDataCache.get(mvpBnfKey).keySet().toArray()[0];
            int mvpGoodCmtIndex = (int) mvpDataCache.get(mvpGoodCmtKey).keySet().toArray()[0];

//            List<String> oldMvpDealTitle = mvpMembers.get(mvpDealIndex).getTitle();
//            List<String> newMvpDealTitle = mergeTitle(oldMvpDealTitle, MVPCriterion.mvpDealTitle);
//            List<String> oldMvpBnfTitle = mvpMembers.get(mvpBnfIndex).getTitle();
//            List<String> newMvpBnfTitle = mergeTitle(oldMvpBnfTitle, MVPCriterion.mvpBnfTitle);
//            List<String> oldMvpCmtTitle = mvpMembers.get(mvpGoodCmtIndex).getTitle();
//            List<String> newMvpCmtTitle = mergeTitle(oldMvpCmtTitle, MVPCriterion.mvpGoodCmtTitle);
//
//            mvpMembers.get(mvpDealIndex).setTitle(newMvpDealTitle);
//            mvpMembers.get(mvpBnfIndex).setTitle(newMvpBnfTitle);
//            mvpMembers.get(mvpGoodCmtIndex).setTitle(newMvpCmtTitle);

            for (int i = 0; i < mvpMembers.size(); i++) {
                MVPMember mvpMember = mvpMembers.get(i);
                List<String> title = mvpMember.getTitle();
                if (i == mvpDealIndex){
                    title.add(MVPCriterion.mvpDealTitle);
                }
                if (i == mvpBnfIndex){
                    title.add(MVPCriterion.mvpBnfTitle);
                }
                if (i == mvpGoodCmtIndex){
                    title.add(MVPCriterion.mvpGoodCmtTitle);
                }
                mvpMember.setTitle(title);
            }
        }
        return mvpMembers;
    }

    public List<String> mergeTitle(List<String> oldMvpTitle, String mvpDealTitle) {
        List<String> newMvpDealTitle = oldMvpTitle == null ? new ArrayList<>() : oldMvpTitle;
        newMvpDealTitle.add(mvpDealTitle);
        return newMvpDealTitle;
    }

    //如果当前元素指标更大，更新最大下标，刷新缓存map中的值
    private int getCurMvpIndex(String mvpKey, int curMvpIndex, Map<String, Map<Integer, Integer>> mvpDataCache, int curIndex, int criterion) {
        if (mvpDataCache.get(mvpKey).get(curMvpIndex)< criterion){
            Map<Integer,Integer> newMvpInfo = new HashMap<>();
            curMvpIndex = curIndex;
            newMvpInfo.put(curIndex, criterion);
            mvpDataCache.put(mvpKey,newMvpInfo);
        }
        return curMvpIndex;
    }

    @Override
    public BaseAdminUser findByUserName(String userName) {
        return baseAdminUserMapper.findByUserName(userName);
    }


    @Override
    public int updatePwd(String userName, String password) {
        password = DigestUtils.Md5(userName,password);
        return baseAdminUserMapper.updatePwd(userName,password);
    }
}
