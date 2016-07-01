package com.up.model;

// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * WeiboEntity entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name="weibo"
    ,catalog="up"
)

public class WeiboEntity  implements java.io.Serializable {


    // Fields

     private Integer id;
     private UserEntity userEntity;
     private DeviceEntity deviceEntity;
     private String content;
     private Double latitude;
     private Double longtitude;
     private String position;
     private Timestamp time;
     private int agreenum;
     private Set<PictureEntity> pictureEntities = new HashSet<PictureEntity>(0);
     private Set<CommentEntity> commentEntities = new HashSet<CommentEntity>(0);
     private Set<AgreeEntity> agreeEntities = new HashSet<AgreeEntity>(0);
     private Set<ArticleEntity> articleEntities = new HashSet<ArticleEntity>(0);
     private Set<VideoEntity> videoEntities = new HashSet<VideoEntity>(0);
     private Set<RepostEntity> repostEntitiesForSourceId = new HashSet<RepostEntity>(0);
     private Set<RepostEntity> repostEntitiesForRepostId = new HashSet<RepostEntity>(0);


    // Constructors

    /** default constructor */
    public WeiboEntity() {
    }

	/** minimal constructor */
    public WeiboEntity(Integer id, UserEntity userEntity, DeviceEntity deviceEntity, String content, Timestamp time) {
        this.id = id;
        this.userEntity = userEntity;
        this.deviceEntity = deviceEntity;
        this.content = content;
        this.time = time;
    }

    /** full constructor */
    public WeiboEntity(Integer id, UserEntity userEntity, DeviceEntity deviceEntity, String content, Double latitude, Double longtitude, String position, Timestamp time, Set<PictureEntity> pictureEntities, Set<CommentEntity> commentEntities, Set<ArticleEntity> articleEntities, Set<VideoEntity> videoEntities, Set<RepostEntity> repostEntitiesForSourceId, Set<RepostEntity> repostEntitiesForRepostId, Set<AgreeEntity> agreeEntities) {
        this.id = id;
        this.userEntity = userEntity;
        this.deviceEntity = deviceEntity;
        this.content = content;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.position = position;
        this.time = time;
        this.pictureEntities = pictureEntities;
        this.commentEntities = commentEntities;
        this.articleEntities = articleEntities;
        this.videoEntities = videoEntities;
        this.repostEntitiesForSourceId = repostEntitiesForSourceId;
        this.repostEntitiesForRepostId = repostEntitiesForRepostId;
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
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="user_id", nullable=false)

    public UserEntity getUserEntity() {
        return this.userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="device_id", nullable=true)

    public DeviceEntity getDeviceEntity() {
        return this.deviceEntity;
    }

    public void setDeviceEntity(DeviceEntity deviceEntity) {
        this.deviceEntity = deviceEntity;
    }

    @Column(name="content", nullable=false)

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name="latitude", precision=22, scale=0, columnDefinition="DOUBLE DEFAULT 0")

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Column(name="longtitude", precision=22, scale=0, columnDefinition="DOUBLE DEFAULT 0")

    public Double getLongtitude() {
        return this.longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    @Column(name="position")

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name="time", length=19, columnDefinition="TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")

    public Timestamp getTime() {
        return this.time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
    
    public int getAgreenum() {
        return this.agreenum;
    }
    
    public void setAgreenum(int agreenum) {
        this.agreenum = agreenum;
    }    
    
    
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="weiboEntity")

    public Set<PictureEntity> getPictureEntities() {
        return this.pictureEntities;
    }

    public void setPictureEntities(Set<PictureEntity> pictureEntities) {
        this.pictureEntities = pictureEntities;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="weiboEntity")

    public Set<CommentEntity> getCommentEntities() {
        return this.commentEntities;
    }

    public void setCommentEntities(Set<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="weiboEntity")

    public Set<ArticleEntity> getArticleEntities() {
        return this.articleEntities;
    }

    public void setArticleEntities(Set<ArticleEntity> articleEntities) {
        this.articleEntities = articleEntities;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="weiboEntity")

    public Set<VideoEntity> getVideoEntities() {
        return this.videoEntities;
    }

    public void setVideoEntities(Set<VideoEntity> videoEntities) {
        this.videoEntities = videoEntities;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="weiboEntityBySourceId")

    public Set<RepostEntity> getRepostEntitiesForSourceId() {
        return this.repostEntitiesForSourceId;
    }

    public void setRepostEntitiesForSourceId(Set<RepostEntity> repostEntitiesForSourceId) {
        this.repostEntitiesForSourceId = repostEntitiesForSourceId;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="weiboEntityByRepostId")

    public Set<RepostEntity> getRepostEntitiesForRepostId() {
        return this.repostEntitiesForRepostId;
    }

    public void setRepostEntitiesForRepostId(Set<RepostEntity> repostEntitiesForRepostId) {
        this.repostEntitiesForRepostId = repostEntitiesForRepostId;
    }

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="weiboEntity")
	public Set<AgreeEntity> getAgreeEntities() {
		return agreeEntities;
	}

	public void setAgreeEntities(Set<AgreeEntity> agreeEntities) {
		this.agreeEntities = agreeEntities;
	}









}
