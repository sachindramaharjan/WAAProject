package test;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity()
@DiscriminatorValue("B")
public class CostCentre extends OrganisationUnit {
	private String costCentreId;

	@Column(length = 16)
	public String getCostCentreId() {
		return costCentreId;
	}

	public void setCostCentreId(String costCentreId) {
		this.costCentreId = costCentreId;
	}
}