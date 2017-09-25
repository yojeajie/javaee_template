package com.payjoy.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 测试用户实体类
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2017/3/8.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
@Entity
@Table(name = "T_TESTUSER")
public class TestUser {
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Id
    @Column(name = "Y_ID", length = 32, nullable = false, updatable = false)
    private String id ;

    /**
     * 用户名
     */
    @Column(name = "Y_NAME", length = 50, nullable = false)
    private String name ;

    /**
     * 密码
     */
    @Column(name = "Y_PASSWORD", length = 25, nullable = false)
    private String password ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestUser testUser = (TestUser) o;

        return id != null ? id.equals(testUser.id) : testUser.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
