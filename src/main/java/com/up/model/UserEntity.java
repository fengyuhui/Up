package com.up.model;

// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * UserEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="user"
    ,catalog="up"
)

public class UserEntity  implements java.io.Serializable {


    // Fields

     private Integer id;
     private String email;
     private Boolean isEmailValidate;
     private Boolean isPhoneValidate;
     private Timestamp lastLogin;
     private String username;
     private String passwordHash;
     private String phone;
     private Timestamp registerTime;
     private String signature;
     private Gender gender;
     private String adress;
     private String nickname;
     private String avatar;
     private Set<PictureEntity> pictureEntities = new HashSet<PictureEntity>(0);
     private Set<VideoEntity> videoEntities = new HashSet<VideoEntity>(0);
     private Set<CommentEntity> commentEntities = new HashSet<CommentEntity>(0);
     private Set<FollowEntity> followEntitiesForFollowUserId = new HashSet<FollowEntity>(0);
     private Set<WeiboEntity> weiboEntities = new HashSet<WeiboEntity>(0);
     private Set<RoleEntity> roleEntities = new HashSet<RoleEntity>(0);
     private Set<ArticleEntity> articleEntities = new HashSet<ArticleEntity>(0);
     private Set<FollowEntity> followEntitiesForUserId = new HashSet<FollowEntity>(0);
     private Set<AgreeEntity> agreeEntities = new HashSet<AgreeEntity>(0);
     
     public static enum Gender {
         MALE,
         FEMALE
     }

    // Constructors

    /** default constructor */
    public UserEntity() {
    }

	/** minimal constructor */
    public UserEntity(Integer id, Boolean isEmailValidate, Boolean isPhoneValidate, Timestamp lastLogin, String username, String passwordHash, Timestamp registerTime, String nickname, String avatar) {
        this.id = id;
        this.isEmailValidate = isEmailValidate;
        this.isPhoneValidate = isPhoneValidate;
        this.lastLogin = lastLogin;
        this.username = username;
        this.passwordHash = passwordHash;
        this.registerTime = registerTime;
        this.nickname = nickname;
        this.avatar = avatar;
    }

    /** full constructor */
    public UserEntity(Integer id, String email, Boolean isEmailValidate, Boolean isPhoneValidate, Timestamp lastLogin, String username, String passwordHash, String phone, Timestamp registerTime, String signature, Gender gender, String adress, String nickname, String avatar, Set<PictureEntity> pictureEntities, Set<VideoEntity> videoEntities, Set<CommentEntity> commentEntities, Set<FollowEntity> followEntitiesForFollowUserId, Set<WeiboEntity> weiboEntities, Set<RoleEntity> roleEntities, Set<ArticleEntity> articleEntities, Set<FollowEntity> followEntitiesForUserId, Set<AgreeEntity> agreeEntities) {
        this.id = id;
        this.email = email;
        this.isEmailValidate = isEmailValidate;
        this.isPhoneValidate = isPhoneValidate;
        this.lastLogin = lastLogin;
        this.username = username;
        this.passwordHash = passwordHash;
        this.phone = phone;
        this.registerTime = registerTime;
        this.signature = signature;
        this.gender = gender;
        this.adress = adress;
        this.nickname = nickname;
        this.avatar = avatar;
        this.pictureEntities = pictureEntities;
        this.videoEntities = videoEntities;
        this.commentEntities = commentEntities;
        this.followEntitiesForFollowUserId = followEntitiesForFollowUserId;
        this.weiboEntities = weiboEntities;
        this.roleEntities = roleEntities;
        this.articleEntities = articleEntities;
        this.followEntitiesForUserId = followEntitiesForUserId;
        this.agreeEntities = agreeEntities;
    }


    // Property accessors
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="email", columnDefinition="VARCHAR(50) DEFAULT NULL")

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="is_email_validate", columnDefinition="TINYINT(1) NOT NULL DEFAULT 0")

    public Boolean getIsEmailValidate() {
        return this.isEmailValidate;
    }

    public void setIsEmailValidate(Boolean isEmailValidate) {
        this.isEmailValidate = isEmailValidate;
    }

    @Column(name="is_phone_validate", columnDefinition="TINYINT(1) NOT NULL DEFAULT 0")

    public Boolean getIsPhoneValidate() {
        return this.isPhoneValidate;
    }

    public void setIsPhoneValidate(Boolean isPhoneValidate) {
        this.isPhoneValidate = isPhoneValidate;
    }

    @Column(name="last_login", length=19, columnDefinition="TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00'")

    public Timestamp getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Column(name="name", nullable=false, length=30)

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="password_hash", nullable=false, length=50)

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Column(name="phone", columnDefinition="VARCHAR(50) DEFAULT NULL")

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name="register_time", length=19, columnDefinition="TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")

    public Timestamp getRegisterTime() {
        return this.registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    @Column(name="signature", length=30)

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Column(name="gender")
    @Enumerated
    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Column(name="adress", columnDefinition="VARCHAR(100) DEFAULT NULL")

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Column(name="nickname", nullable=false, length=30)

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Column(name="avatar", nullable=false)

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userEntity")

    public Set<PictureEntity> getPictureEntities() {
        return this.pictureEntities;
    }

    public void setPictureEntities(Set<PictureEntity> pictureEntities) {
        this.pictureEntities = pictureEntities;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userEntity")

    public Set<VideoEntity> getVideoEntities() {
        return this.videoEntities;
    }

    public void setVideoEntities(Set<VideoEntity> videoEntities) {
        this.videoEntities = videoEntities;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userEntity")

    public Set<CommentEntity> getCommentEntities() {
        return this.commentEntities;
    }

    public void setCommentEntities(Set<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userEntityByFollowUserId")

    public Set<FollowEntity> getFollowEntitiesForFollowUserId() {
        return this.followEntitiesForFollowUserId;
    }

    public void setFollowEntitiesForFollowUserId(Set<FollowEntity> followEntitiesForFollowUserId) {
        this.followEntitiesForFollowUserId = followEntitiesForFollowUserId;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userEntity")

    public Set<WeiboEntity> getWeiboEntities() {
        return this.weiboEntities;
    }

    public void setWeiboEntities(Set<WeiboEntity> weiboEntities) {
        this.weiboEntities = weiboEntities;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userEntity")

    public Set<RoleEntity> getRoleEntities() {
        return this.roleEntities;
    }

    public void setRoleEntities(Set<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userEntity")

    public Set<ArticleEntity> getArticleEntities() {
        return this.articleEntities;
    }

    public void setArticleEntities(Set<ArticleEntity> articleEntities) {
        this.articleEntities = articleEntities;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userEntityByUserId")

    public Set<FollowEntity> getFollowEntitiesForUserId() {
        return this.followEntitiesForUserId;
    }

    public void setFollowEntitiesForUserId(Set<FollowEntity> followEntitiesForUserId) {
        this.followEntitiesForUserId = followEntitiesForUserId;
    }
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userEntity")
	public Set<AgreeEntity> getAgreeEntities() {
		return agreeEntities;
	}

	public void setAgreeEntities(Set<AgreeEntity> agreeEntities) {
		this.agreeEntities = agreeEntities;
	}









}
