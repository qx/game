/**
 * 
 */
package com.fullwish.other;

/**
 * @author fullwish
 *
 */
public enum Choose {
    SHU{
        public String getName(){return "���";}
    },  WEI{
        public String getName(){return "κ��";}
    },
    WU{
        public String getName(){return "���";}
    };
    public abstract String getName();

}
