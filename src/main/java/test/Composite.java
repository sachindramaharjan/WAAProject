package test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "parent_id",
		"name" }) })
public class Composite extends Component {

	private String name;
	private Set<Component> children;

	public Composite() {
		super();
		this.children = new HashSet<Component>();
	}

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The <code>parent</code> must be overrided in order to be able to declare
	 * <code>uniqueConstraints</code> on the class (see this class definition),
	 * otherwise it will say "Unable to find column with logical name
	 * <code>Composite.parent_id</code>"
	 */
	@Override
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE,
			CascadeType.PERSIST }, optional = true)
	public Composite getParent() {
		return this.parent;
	}

	public void setParent(Composite parent) {
		this.parent = parent;
	}

	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<Component> getChildren() {
		return children;
	}

	public void setChildren(Set<Component> children) {
		this.children = children;
	}


}
