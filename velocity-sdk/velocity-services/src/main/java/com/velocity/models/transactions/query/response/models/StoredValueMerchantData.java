/**
 * 
 */
package com.velocity.models.transactions.query.response.models;

import com.google.gson.annotations.SerializedName;
import com.velocity.enums.IndustryType;

/**
 * This class defines the attributes for StoredValueMerchantData
 * 
 * @author Vimal Kumar
 * @date 12-March-2015
 */
public class StoredValueMerchantData {

	@SerializedName("AgentChain")
	private String agentChain;

	@SerializedName("ClientNumber")
	private String clientNumber;

	@SerializedName("IndustryType")
	private IndustryType industryType;

	@SerializedName("SIC")
	private String sIC;

	@SerializedName("StoreId")
	private String storeId;

	@SerializedName("TerminalId")
	private String terminalId;

	public String getAgentChain() {
		return agentChain;
	}

	public void setAgentChain(String agentChain) {
		this.agentChain = agentChain;
	}

	public String getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}

	public IndustryType getIndustryType() {
		return industryType;
	}

	public void setIndustryType(IndustryType industryType) {
		this.industryType = industryType;
	}

	public String getsIC() {
		return sIC;
	}

	public void setsIC(String sIC) {
		this.sIC = sIC;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

}
