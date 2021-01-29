package com.moon.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class MoonImage {
	@Id
	@GeneratedValue
	private Long ino;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_project_for_image"))
	private MoonProject moonProjects;

	@Lob
	private byte[] image;

	@Column(nullable = false, unique = true)
	private String imageName;

	public MoonImage() {
		super();
	}

	public MoonImage(MoonProject moonProjects, byte[] image, String imageName) {
		super();
		this.moonProjects = moonProjects;
		this.image = image;
		this.imageName = imageName;
	}
}
