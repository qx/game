/**
 * 
 */
package com.fullwish.base;

import java.io.Serializable;

import org.json.JSONObject;

/**
 * @author fullwish
 *
 */
/**
 * 
 */


public class User implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1625526557511499762L;
    
    private JSONObject json_user;

    /* 绑定的google账号 */
    private String user_google;

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
    private String user_carrer;

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

    public String getUser_google() {
        return user_google;
    }

    public User() {

    }

    /**
     * @param userGoogle
     * @param userNickname
     * @param userLevel
     */
    public User(String userGoogle, String userNickname, int userLevel) {
        super();
        user_google = userGoogle;
        user_nickname = userNickname;
        user_level = userLevel;
    }
    public User(JSONObject json_user) {
        
    }

    public void setUser_google(String userGoogle) {
        user_google = userGoogle;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String userNickname) {
        user_nickname = userNickname;
    }

    public int getUser_action() {
        return user_action;
    }

    public void setUser_action(int userAction) {
        user_action = userAction;
    }

    public int getUser_attack() {
        return user_attack;
    }

    public void setUser_attack(int userAttack) {
        user_attack = userAttack;
    }

    public int getUser_defense() {
        return user_defense;
    }

    public void setUser_defense(int userDefense) {
        user_defense = userDefense;
    }

    public int getUser_experience() {
        return user_experience;
    }

    public void setUser_experience(int userExperience) {
        user_experience = userExperience;
    }

    public int getUser_friend() {
        return user_friend;
    }

    public void setUser_friend(int userFriend) {
        user_friend = userFriend;
    }

    public int getUser_energy() {
        return user_energy;
    }

    public void setUser_energy(int userEnergy) {
        user_energy = userEnergy;
    }

    public int getUser_healthpoint() {
        return user_healthpoint;
    }

    public void setUser_healthpoint(int userHealthpoint) {
        user_healthpoint = userHealthpoint;
    }

    public int getUser_hideAttack() {
        return user_hideAttack;
    }

    public void setUser_hideAttack(int userHideAttack) {
        user_hideAttack = userHideAttack;
    }

    public int getUser_hideDefense() {
        return user_hideDefense;
    }

    public void setUser_hideDefense(int userHideDefense) {
        user_hideDefense = userHideDefense;
    }

    public int getUser_level() {
        return user_level;
    }

    public void setUser_level(int userLevel) {
        user_level = userLevel;
    }

    public int getUser_money() {
        return user_money;
    }

    public void setUser_money(int userMoney) {
        user_money = userMoney;
    }

    public int getUser_reward_Point() {
        return user_reward_Point;
    }

    public void setUser_reward_Point(int userRewardPoint) {
        user_reward_Point = userRewardPoint;
    }

    public int getUser_skill_Point() {
        return user_skill_Point;
    }

    public void setUser_skill_Point(int userSkillPoint) {
        user_skill_Point = userSkillPoint;
    }

    public String getUser_carrer() {
        return user_carrer;
    }

    public void setUser_carrer(String userCarrer) {
        user_carrer = userCarrer;
    }

    public String getUser_country() {
        return user_country;
    }

    public void setUser_country(String usercountry) {
        user_country = usercountry;
    }

    public String getUser_microblog() {
        return user_microblog;
    }

    public void setUser_microblog(String userMicroblog) {
        user_microblog = userMicroblog;
    }

    public int getUser_fight_win() {
        return user_fight_win;
    }

    public void setUser_fight_win(int userFightWin) {
        user_fight_win = userFightWin;
    }

    public int getUser_fight_lose() {
        return user_fight_lose;
    }

    public void setUser_fight_lose(int userFightLose) {
        user_fight_lose = userFightLose;
    }

    public int getUser_kidnap() {
        return user_kidnap;
    }

    public void setUser_kidnap(int userKidnap) {
        user_kidnap = userKidnap;
    }

    public int getUser_bekidnap() {
        return user_bekidnap;
    }

    public void setUser_bekidnap(int userBekidnap) {
        user_bekidnap = userBekidnap;
    }

    public int getUser_rescue() {
        return user_rescue;
    }

    public void setUser_rescue(int userRescue) {
        user_rescue = userRescue;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((user_google == null) ? 0 : user_google.hashCode());
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
        if (user_google == null) {
            if (other.user_google != null)
                return false;
        } else if (!user_google.equals(other.user_google))
            return false;
        return true;
    }

    /**
     * @param json_user the json_user to set
     */
    public void setJson_user(JSONObject json_user) {
        this.json_user = json_user;
    }

    /**
     * @return the json_user
     */
    public JSONObject getJson_user() {
        return json_user;
    }
}

