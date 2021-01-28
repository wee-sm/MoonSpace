package com.moon.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class MoonProjects {
	@Id
	@GeneratedValue
	@Column(nullable = false, unique = true)
	private Long pno;

	@Column(nullable = false)
	private String projectName;

	@OneToMany(mappedBy = "moonProjects", cascade = CascadeType.ALL)
	@OrderBy("imageName ASC")
	private List<MoonImages> moonImages;
}
