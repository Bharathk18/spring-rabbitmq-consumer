package com.example.springrabbitmqconsumer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "dealer_type")
public class DealerType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DEALER_TYPE_ID" )
	private long dealerTypeId;
	
	@Column(name="poi_type_cd")
	private String poiTypeCd;
	
	@Column(name="poi_type_name")
	private String poiTypeName;
	
	@Column(name="poi_type_description")
	private String poiTypeDescription;



	public long getDealerTypeId() {
		return dealerTypeId;
	}

	public void setDealerTypeId(long dealerTypeId) {
		this.dealerTypeId = dealerTypeId;
	}

	public String getPoiTypeCd() {
		return poiTypeCd;
	}

	public void setPoiTypeCd(String poiTypeCd) {
		this.poiTypeCd = poiTypeCd;
	}

	public String getPoiTypeName() {
		return poiTypeName;
	}

	public void setPoiTypeName(String poiTypeName) {
		this.poiTypeName = poiTypeName;
	}

	public String getPoiTypeDescription() {
		return poiTypeDescription;
	}

	public void setPoiTypeDescription(String poiTypeDescription) {
		this.poiTypeDescription = poiTypeDescription;
	}
	
	

}
