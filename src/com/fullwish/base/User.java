/**
 * 
 */
package com.fullwish.base;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.fullwish.utils.JsonUtil;

/**
 * @author fullwish
 * 
 */
public class User {
    @SuppressWarnings("unused")
    private HashMap<String, String> map = new HashMap<String, String>();

    @SuppressWarnings("unchecked")
    @Override
    public String toString() {
        HashMap<String, String> user_map;
        user_map = new HashMap<String, String>();
        // * @param user_email
        user_map.put("user_email", this.user_email);
        // * @param user_password
        user_map.put("user_password", this.user_password);
        // * @param user_nickname
        user_map.put("user_nickname", this.user_nickname);
        // * @param user_action
        user_map.put("user_action", this.user_action + "");
        // * @param user_attack
        user_map.put("user_attack", this.user_attack + "");
        // * @param user_defense
        user_map.put("user_defense", this.user_defense + "");
        // * @param user_experience
        user_map.put("user_experience", this.user_experience + "");
        // * @param user_friend
        user_map.put("user_friend", this.user_friend + "");
        // * @param user_energy
        user_map.put("user_energy", this.user_energy + "");
        // * @param user_healthpoint
        user_map.put("user_healthpoint", this.user_healthpoint + "");
        // * @param user_hideAttack
        user_map.put("user_hideAttack", this.user_hideAttack + "");
        // * @param user_hideDefense
        user_map.put("user_hideDefense", this.user_hideDefense + "");
        // * @param user_level
        user_map.put("user_level", this.user_level + "");
        // * @param user_money
        user_map.put("user_money", this.user_money + "");
        // * @param user_reward_Point
        user_map.put("user_reward_Point", this.user_reward_Point + "");
        // * @param user_skill_Point
        user_map.put("user_skill_Point", this.user_skill_Point + "");
        // * @param user_career
        user_map.put("user_career", this.user_career + "");
        // * @param user_country
        user_map.put("user_country", this.user_country + "");
        // * @param user_microblog
        user_map.put("user_microblog", this.user_microblog + "");
        // * @param user_fight_win
        user_map.put("user_fight_win", this.user_fight_win + "");
        // * @param user_fight_lose
        user_map.put("user_fight_lose", this.user_fight_lose + "");
        // * @param user_kidnap
        user_map.put("user_kidnap", this.user_kidnap + "");
        // * @param user_bekidnap
        user_map.put("user_bekidnap", this.user_bekidnap + "");
        // * @param user_rescue
        user_map.put("user_rescue", this.user_rescue + "");
        // */
        String user_string = JsonUtil.map2Json((Map) user_map);
        return user_string;
    }

    private JSONObject user_json;

    /**
     * @param userJsob
     */
    public User(JSONObject userJson) {
        super();
        user_json = userJson;
    }

    /* 用户邮箱,唯一标示,(取回密码) */
    private String user_email;

    /** 密码 * */
    private String user_password;// 采用MD5加密

    /* 用户昵称 */
    private String user_nickname;

    /* 行动力 */
    private int user_action;

    /* 攻击力 */
    private int user_attack;

    /* 防御力 */
    private int user_defense;

    /* 经验值 */
    private int user_experience;

    /* 朋友数量 */
    private int user_friend;

    /* 能量 */
    private int user_energy;

    /* 血量值 */
    private int user_healthpoint;

    /* 隐藏攻击力 */
    private int user_hideAttack;

    /* 隐藏防御力 */
    private int user_hideDefense;

    /* 等级 */
    private int user_level;

    /* 金钱 */
    private int user_money;

    /* 奖励点数 */
    private int user_reward_Point;

    /* 技能点数 */
    private int user_skill_Point;

    /* 职业 */
    private String user_career;

    /* 所属地区 */
    private String user_country;

    /* 微博账号 */
    private String user_microblog;

    /* 战斗胜利场数 */
    private int user_fight_win;

    /* 战斗失败次数 */
    private int user_fight_lose;

    /* 绑架次数 */
    private int user_kidnap;

    /* 被绑次数 */
    private int user_bekidnap;

    /* 解救次数 */
    private int user_rescue;

    public User() {

    }

    /**
     * @param user_email
     *            用户账号唯一标示,也可用作取回密码
     * @param user_password
     *            用户密码,登录游戏 创建测试数据,初始值设置如下 行动力3 user_action 攻击力0 防御力0 经验值0 朋友数量0
     *            能量:10 user_energy 血量值:100 user_healthpoint 隐藏攻击力:0 隐藏防御力:0
     *            等级:1 user_level 金钱:0 奖励点数:0 技能点数:0 职业:未定 所属势力: 微博账号:未定// 测试
     *            user_microblog="qx.ouyang@gmail.com" 战斗胜利场数:0 战斗失败场数:0 绑架次数:0
     *            被绑次数:0
     */
    public User(String user_email, String user_password) {
        super();
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_action = 3;
        this.user_energy = 10;
        this.user_healthpoint = 100;
        this.user_level = 1;

    }

    public String getUser_email() throws JSONException {
        return user_email = new JSONObject(user_json.getString("user")).getString("user_email");
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() throws JSONException {
        return user_password = new JSONObject(user_json.getString("user")).getString("user_password");
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_nickname() throws JSONException {
        return user_nickname = new JSONObject(user_json.getString("user")).getString("user_nickname");
    }

    public void setUser_nickname(String userNickname) {
        user_nickname = userNickname;
    }

    public int getUser_action() throws NumberFormatException, JSONException {
        return user_action = Integer.parseInt(new JSONObject(user_json.getString("user")).getString("user_action"));
    }

    public void setUser_action(int userAction) {
        user_action = userAction;
    }

    public int getUser_attack() throws NumberFormatException, JSONException {
        return user_attack = Integer.parseInt(new JSONObject(user_json.getString("user")).getString("user_attack"));
    }

    public void setUser_attack(int userAttack) {
        user_attack = userAttack;
    }

    public int getUser_defense() throws NumberFormatException, JSONException {
        return user_defense = Integer.parseInt(new JSONObject(user_json.getString("user")).getString("user_defense"));
    }

    public void setUser_defense(int userDefense) {
        user_defense = userDefense;
    }

    public int getUser_experience() throws NumberFormatException, JSONException {
        return user_experience = Integer.parseInt(new JSONObject(user_json.getString("user"))
                .getString("user_experience"));
    }

    public void setUser_experience(int userExperience) {
        user_experience = userExperience;
    }

    public int getUser_friend() throws NumberFormatException, JSONException {
        return user_friend = Integer.parseInt(new JSONObject(user_json.getString("user")).getString("user_friend"));
    }

    public void setUser_friend(int userFriend) {
        user_friend = userFriend;
    }

    public int getUser_energy() throws NumberFormatException, JSONException {
        return user_energy = Integer.parseInt(new JSONObject(user_json.getString("user")).getString("user_energy"));

    }

    public void setUser_energy(int userEnergy) {
        user_energy = userEnergy;
    }

    public int getUser_healthpoint() throws NumberFormatException, JSONException {
        return user_healthpoint = Integer.parseInt(new JSONObject(user_json.getString("user"))
                .getString("user_healthpoint"));
    }

    public void setUser_healthpoint(int userHealthpoint) {
        user_healthpoint = userHealthpoint;
    }

    public int getUser_hideAttack() throws NumberFormatException, JSONException {
        return user_hideAttack = Integer.parseInt(new JSONObject(user_json.getString("user"))
                .getString("user_hideAttack"));
    }

    public void setUser_hideAttack(int userHideAttack) {
        user_hideAttack = userHideAttack;
    }

    public int getUser_hideDefense() throws NumberFormatException, JSONException {
        return user_hideDefense = Integer.parseInt(new JSONObject(user_json.getString("user"))
                .getString("user_hideDefense"));
    }

    public void setUser_hideDefense(int userHideDefense) {
        user_hideDefense = userHideDefense;
    }

    public int getUser_level() throws NumberFormatException, JSONException {
        return user_level = Integer.parseInt(new JSONObject(user_json.getString("user")).getString("user_level"));
    }

    public void setUser_level(int userLevel) {
        user_level = userLevel;
    }

    public int getUser_money() throws NumberFormatException, JSONException {
        return user_money = Integer.parseInt(new JSONObject(user_json.getString("user")).getString("user_money"));
    }

    public void setUser_money(int userMoney) {
        user_money = userMoney;
    }

    public int getUser_reward_Point() throws NumberFormatException, JSONException {
        return user_reward_Point = Integer.parseInt(new JSONObject(user_json.getString("user"))
                .getString("user_reward_Point"));
    }

    public void setUser_reward_Point(int userRewardPoint) {
        user_reward_Point = userRewardPoint;
    }

    public int getUser_skill_Point() throws NumberFormatException, JSONException {
        return user_skill_Point = Integer.parseInt(new JSONObject(user_json.getString("user"))
                .getString("user_skill_Point"));
    }

    public void setUser_skill_Point(int userSkillPoint) {
        user_skill_Point = userSkillPoint;
    }

    public String getUser_career() throws JSONException {
        return user_career = new JSONObject(user_json.getString("user")).getString("user_career");
    }

    public void setUser_career(String userCareer) {
        user_career = userCareer;
    }

    public String getUser_country() throws JSONException {
        return user_country = new JSONObject(user_json.getString("user")).getString("user_country");
    }

    public void setUser_country(String usercountry) {
        user_country = usercountry;
    }

    public String getUser_microblog() throws JSONException {
        return user_microblog = new JSONObject(user_json.getString("user")).getString("user_microblog");
    }

    public void setUser_microblog(String userMicroblog) {
        user_microblog = userMicroblog;
    }

    public int getUser_fight_win() throws NumberFormatException, JSONException {
        return user_fight_win = Integer.parseInt(new JSONObject(user_json.getString("user"))
                .getString("user_fight_win"));
    }

    public void setUser_fight_win(int userFightWin) {
        user_fight_win = userFightWin;
    }

    public int getUser_fight_lose() throws NumberFormatException, JSONException {
        return user_fight_lose = Integer.parseInt(new JSONObject(user_json.getString("user"))
                .getString("user_fight_lose"));
    }

    public void setUser_fight_lose(int userFightLose) {
        user_fight_lose = userFightLose;
    }

    public int getUser_kidnap() throws NumberFormatException, JSONException {
        return user_kidnap = Integer.parseInt(new JSONObject(user_json.getString("user")).getString("user_kidnap"));
    }

    public void setUser_kidnap(int userKidnap) {
        user_kidnap = userKidnap;
    }

    public int getUser_bekidnap() throws NumberFormatException, JSONException {
        return user_bekidnap = Integer.parseInt(new JSONObject(user_json.getString("user")).getString("user_bekidnap"));
    }

    public void setUser_bekidnap(int userBekidnap) {
        user_bekidnap = userBekidnap;
    }

    public int getUser_rescue() throws NumberFormatException, JSONException {
        return user_rescue = Integer.parseInt(new JSONObject(user_json.getString("user")).getString("user_rescue"));
    }

    public void setUser_rescue(int userRescue) {
        user_rescue = userRescue;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final User other = (User) obj;
        if (user_email == null) {
            if (other.user_email != null)
                return false;
        } else if (!user_email.equals(other.user_email))
            return false;
        return true;
    }
}
