package test;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GeneratorType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "0")
public abstract class OrganisationUnit {
	private Set<OrganisationUnit> children;
	private OrganisationUnit parent;
	private String name;
	private Long id;
	private Double budget;

	@Transient()
	public boolean isLeaf() {
		return (children == null || children.size() == 0);
	}

	@Transient()
	public boolean isRoot() {
		return (parent == null);
	}

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<OrganisationUnit> getChildren() {
		return children;
	}

	public void setChildren(Set<OrganisationUnit> children) {
		this.children = children;
	}

	@Column()
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne()
	@JoinColumn()
	public OrganisationUnit getParent() {
		return parent;
	}

	public void setParent(OrganisationUnit parent) {
		this.parent = parent;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	@Column(scale = 2)
	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}
}