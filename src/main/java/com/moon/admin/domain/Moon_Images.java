package com.moon.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Moon_Images extends Moon_AbstractEntity {
	@Column(nullable = false, unique = true)
	private Long ino;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_project_for_image"))
	private Moon_Projects moonProjects;

	@Lob
	private byte[] image;

	@Column(nullable = false, unique = true)
	private String imageName;

	public Moon_Images() {
		super();
	}

	public Moon_Images(Long ino, Moon_Projects moonProjects, byte[] image, String imageName) {
		super();
		this.ino = ino;
		this.moonProjects = moonProjects;
		this.image = image;
		this.imageName = imageName;
	}

	public Long getIno() {
		return ino;
	}

	public void setIno(Long ino) {
		this.ino = ino;
	}

	public Moon_Projects getMoonProjects() {
		return moonProjects;
	}

	public void setMoonProjects(Moon_Projects moonProjects) {
		this.moonProjects = moonProjects;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}