package org.openmrs.fhir;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Configuration;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.EnumFactory;
import org.hl7.fhir.r4.model.Enumeration;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.PrimitiveType;
import org.hl7.fhir.r4.model.Property;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.ResourceType;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.utilities.Utilities;

import ca.uhn.fhir.model.api.IElement;
import ca.uhn.fhir.model.api.annotation.Binding;
import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import ca.uhn.fhir.rest.gclient.TokenClientParam;
import ca.uhn.fhir.util.ElementUtil;

@ResourceDef(name = "InventoryItem", profile = "http://hl7.org/fhir/StructureDefinition/InventoryItem")
public class InventoryItem extends DomainResource {
	
	@Child(name = "identifier", type = { Identifier.class }, order = 0, min = 0, max = -1, modifier = false, summary = true)
	@Description(shortDefinition = "Business identifier for the inventory item", formalDefinition = "Business identifier for the inventory item.")
	protected List<Identifier> identifier;
	
	@Child(name = "status", type = { CodeType.class }, order = 1, min = 1, max = 1, modifier = false, summary = true)
	@Description(shortDefinition = "active | inactive | entered-in-error | unknown", formalDefinition = "Status of the item entry.")
	@Binding(valueSet = "http://hl7.org/fhir/ValueSet/inventoryitem-status")
	protected Enumeration<InventoryItemStatusCodes> status;
	
	@Child(name = "category", type = {
	        CodeableConcept.class }, order = 2, min = 0, max = -1, modifier = false, summary = true)
	@Description(shortDefinition = "Category or class of the item", formalDefinition = "Category or class of the item.")
	protected List<CodeableConcept> category;
	
	@Child(name = "code", type = { CodeableConcept.class }, order = 3, min = 0, max = -1, modifier = false, summary = true)
	@Description(shortDefinition = "Code designating the specific type of item", formalDefinition = "Code designating the specific type of item.")
	protected List<CodeableConcept> code;
	
	@Child(name = "name", type = {}, order = 4, min = 0, max = -1, modifier = false, summary = true)
	@Description(shortDefinition = "The item name(s) - the brand name, or common name, functional name, generic name or others", formalDefinition = "The item name(s) - the brand name, or common name, functional name, generic name.")
	protected List<InventoryItemNameComponent> name;
	
	@Child(name = "description", type = {}, order = 6, min = 0, max = 1, modifier = false, summary = false)
	@Description(shortDefinition = "Descriptive characteristics of the item", formalDefinition = "The descriptive characteristics of the inventory item.")
	protected InventoryItemDescriptionComponent description;
	
	@Child(name = "inventoryStatus", type = {
	        CodeableConcept.class }, order = 7, min = 0, max = -1, modifier = false, summary = true)
	@Description(shortDefinition = "The usage status like recalled, in use, discarded", formalDefinition = "The usage status e.g. recalled, in use, discarded... This can be used to indicate that the items have been taken out of inventory, or are in use, etc.")
	protected List<CodeableConcept> inventoryStatus;
	
	@Child(name = "baseUnit", type = {
	        CodeableConcept.class }, order = 8, min = 0, max = 1, modifier = false, summary = true)
	@Description(shortDefinition = "The base unit of measure - the unit in which the product is used or counted", formalDefinition = "The base unit of measure - the unit in which the product is used or counted.")
	protected CodeableConcept baseUnit;
	
	@Child(name = "netContent", type = { Quantity.class }, order = 9, min = 0, max = 1, modifier = false, summary = true)
	@Description(shortDefinition = "Net content or amount present in the item", formalDefinition = "Net content or amount present in the item.")
	protected Quantity netContent;
	
	private static final long serialVersionUID = 2127201564L;
	
	@SearchParamDefinition(name = "code", path = "InventoryItem.code", description = "Search for products that match this code", type = "token")
	public static final String SP_CODE = "code";
	
	public static final TokenClientParam CODE = new TokenClientParam("code");
	
	@SearchParamDefinition(name = "identifier", path = "InventoryItem.identifier", description = "The identifier of the item", type = "token")
	public static final String SP_IDENTIFIER = "identifier";
	
	public static final TokenClientParam IDENTIFIER = new TokenClientParam("identifier");
	
	@SearchParamDefinition(name = "status", path = "InventoryItem.status", description = "The status of the item", type = "token")
	public static final String SP_STATUS = "status";
	
	public static final TokenClientParam STATUS = new TokenClientParam("status");
	
	public InventoryItem() {
	}
	
	public InventoryItem(InventoryItemStatusCodes status) {
		this.setStatus(status);
	}
	
	public List<Identifier> getIdentifier() {
		if (this.identifier == null) {
			this.identifier = new ArrayList();
		}
		
		return this.identifier;
	}
	
	public InventoryItem setIdentifier(List<Identifier> theIdentifier) {
		this.identifier = theIdentifier;
		return this;
	}
	
	public boolean hasIdentifier() {
		if (this.identifier == null) {
			return false;
		} else {
			Iterator var1 = this.identifier.iterator();
			
			Identifier item;
			do {
				if (!var1.hasNext()) {
					return false;
				}
				
				item = (Identifier) var1.next();
			} while (item.isEmpty());
			
			return true;
		}
	}
	
	public Identifier addIdentifier() {
		Identifier t = new Identifier();
		if (this.identifier == null) {
			this.identifier = new ArrayList();
		}
		
		this.identifier.add(t);
		return t;
	}
	
	public InventoryItem addIdentifier(Identifier t) {
		if (t == null) {
			return this;
		} else {
			if (this.identifier == null) {
				this.identifier = new ArrayList();
			}
			
			this.identifier.add(t);
			return this;
		}
	}
	
	public Identifier getIdentifierFirstRep() {
		if (this.getIdentifier().isEmpty()) {
			this.addIdentifier();
		}
		
		return this.getIdentifier().get(0);
	}
	
	public Enumeration<InventoryItemStatusCodes> getStatusElement() {
		if (this.status == null) {
			if (Configuration.errorOnAutoCreate()) {
				throw new Error("Attempt to auto-create InventoryItem.status");
			}
			
			if (Configuration.doAutoCreate()) {
				this.status = new Enumeration(new InventoryItemStatusCodesEnumFactory());
			}
		}
		
		return this.status;
	}
	
	public boolean hasStatusElement() {
		return this.status != null && !this.status.isEmpty();
	}
	
	public boolean hasStatus() {
		return this.status != null && !this.status.isEmpty();
	}
	
	public InventoryItem setStatusElement(Enumeration<InventoryItemStatusCodes> value) {
		this.status = value;
		return this;
	}
	
	public InventoryItemStatusCodes getStatus() {
		return this.status == null ? null : (InventoryItemStatusCodes) this.status.getValue();
	}
	
	public InventoryItem setStatus(InventoryItemStatusCodes value) {
		if (this.status == null) {
			this.status = new Enumeration(new InventoryItemStatusCodesEnumFactory());
		}
		
		this.status.setValue(value);
		return this;
	}
	
	public List<CodeableConcept> getCategory() {
		if (this.category == null) {
			this.category = new ArrayList();
		}
		
		return this.category;
	}
	
	public InventoryItem setCategory(List<CodeableConcept> theCategory) {
		this.category = theCategory;
		return this;
	}
	
	public boolean hasCategory() {
		if (this.category == null) {
			return false;
		} else {
			Iterator var1 = this.category.iterator();
			
			CodeableConcept item;
			do {
				if (!var1.hasNext()) {
					return false;
				}
				
				item = (CodeableConcept) var1.next();
			} while (item.isEmpty());
			
			return true;
		}
	}
	
	public CodeableConcept addCategory() {
		CodeableConcept t = new CodeableConcept();
		if (this.category == null) {
			this.category = new ArrayList();
		}
		
		this.category.add(t);
		return t;
	}
	
	public InventoryItem addCategory(CodeableConcept t) {
		if (t == null) {
			return this;
		} else {
			if (this.category == null) {
				this.category = new ArrayList();
			}
			
			this.category.add(t);
			return this;
		}
	}
	
	public CodeableConcept getCategoryFirstRep() {
		if (this.getCategory().isEmpty()) {
			this.addCategory();
		}
		
		return (CodeableConcept) this.getCategory().get(0);
	}
	
	public List<CodeableConcept> getCode() {
		if (this.code == null) {
			this.code = new ArrayList();
		}
		
		return this.code;
	}
	
	public InventoryItem setCode(List<CodeableConcept> theCode) {
		this.code = theCode;
		return this;
	}
	
	public boolean hasCode() {
		if (this.code == null) {
			return false;
		} else {
			Iterator var1 = this.code.iterator();
			
			CodeableConcept item;
			do {
				if (!var1.hasNext()) {
					return false;
				}
				
				item = (CodeableConcept) var1.next();
			} while (item.isEmpty());
			
			return true;
		}
	}
	
	public CodeableConcept addCode() {
		CodeableConcept t = new CodeableConcept();
		if (this.code == null) {
			this.code = new ArrayList();
		}
		
		this.code.add(t);
		return t;
	}
	
	public InventoryItem addCode(CodeableConcept t) {
		if (t == null) {
			return this;
		} else {
			if (this.code == null) {
				this.code = new ArrayList();
			}
			
			this.code.add(t);
			return this;
		}
	}
	
	public CodeableConcept getCodeFirstRep() {
		if (this.getCode().isEmpty()) {
			this.addCode();
		}
		
		return (CodeableConcept) this.getCode().get(0);
	}
	
	public List<InventoryItemNameComponent> getName() {
		if (this.name == null) {
			this.name = new ArrayList();
		}
		
		return this.name;
	}
	
	public InventoryItem setName(List<InventoryItemNameComponent> theName) {
		this.name = theName;
		return this;
	}
	
	public boolean hasName() {
		if (this.name == null) {
			return false;
		} else {
			Iterator var1 = this.name.iterator();
			
			InventoryItemNameComponent item;
			do {
				if (!var1.hasNext()) {
					return false;
				}
				
				item = (InventoryItemNameComponent) var1.next();
			} while (item.isEmpty());
			
			return true;
		}
	}
	
	public InventoryItemNameComponent addName() {
		InventoryItemNameComponent t = new InventoryItemNameComponent();
		if (this.name == null) {
			this.name = new ArrayList();
		}
		
		this.name.add(t);
		return t;
	}
	
	public InventoryItem addName(InventoryItemNameComponent t) {
		if (t == null) {
			return this;
		} else {
			if (this.name == null) {
				this.name = new ArrayList();
			}
			
			this.name.add(t);
			return this;
		}
	}
	
	public InventoryItemNameComponent getNameFirstRep() {
		if (this.getName().isEmpty()) {
			this.addName();
		}
		
		return (InventoryItemNameComponent) this.getName().get(0);
	}
	
	public InventoryItemDescriptionComponent getDescription() {
		if (this.description == null) {
			if (Configuration.errorOnAutoCreate()) {
				throw new Error("Attempt to auto-create InventoryItem.description");
			}
			
			if (Configuration.doAutoCreate()) {
				this.description = new InventoryItemDescriptionComponent();
			}
		}
		
		return this.description;
	}
	
	public boolean hasDescription() {
		return this.description != null && !this.description.isEmpty();
	}
	
	public InventoryItem setDescription(InventoryItemDescriptionComponent value) {
		this.description = value;
		return this;
	}
	
	public List<CodeableConcept> getInventoryStatus() {
		if (this.inventoryStatus == null) {
			this.inventoryStatus = new ArrayList();
		}
		
		return this.inventoryStatus;
	}
	
	public InventoryItem setInventoryStatus(List<CodeableConcept> theInventoryStatus) {
		this.inventoryStatus = theInventoryStatus;
		return this;
	}
	
	public boolean hasInventoryStatus() {
		if (this.inventoryStatus == null) {
			return false;
		} else {
			Iterator var1 = this.inventoryStatus.iterator();
			
			CodeableConcept item;
			do {
				if (!var1.hasNext()) {
					return false;
				}
				
				item = (CodeableConcept) var1.next();
			} while (item.isEmpty());
			
			return true;
		}
	}
	
	public CodeableConcept addInventoryStatus() {
		CodeableConcept t = new CodeableConcept();
		if (this.inventoryStatus == null) {
			this.inventoryStatus = new ArrayList();
		}
		
		this.inventoryStatus.add(t);
		return t;
	}
	
	public InventoryItem addInventoryStatus(CodeableConcept t) {
		if (t == null) {
			return this;
		} else {
			if (this.inventoryStatus == null) {
				this.inventoryStatus = new ArrayList();
			}
			
			this.inventoryStatus.add(t);
			return this;
		}
	}
	
	public CodeableConcept getInventoryStatusFirstRep() {
		if (this.getInventoryStatus().isEmpty()) {
			this.addInventoryStatus();
		}
		
		return (CodeableConcept) this.getInventoryStatus().get(0);
	}
	
	public CodeableConcept getBaseUnit() {
		if (this.baseUnit == null) {
			if (Configuration.errorOnAutoCreate()) {
				throw new Error("Attempt to auto-create InventoryItem.baseUnit");
			}
			
			if (Configuration.doAutoCreate()) {
				this.baseUnit = new CodeableConcept();
			}
		}
		
		return this.baseUnit;
	}
	
	public boolean hasBaseUnit() {
		return this.baseUnit != null && !this.baseUnit.isEmpty();
	}
	
	public InventoryItem setBaseUnit(CodeableConcept value) {
		this.baseUnit = value;
		return this;
	}
	
	public Quantity getNetContent() {
		if (this.netContent == null) {
			if (Configuration.errorOnAutoCreate()) {
				throw new Error("Attempt to auto-create InventoryItem.netContent");
			}
			
			if (Configuration.doAutoCreate()) {
				this.netContent = new Quantity();
			}
		}
		
		return this.netContent;
	}
	
	public boolean hasNetContent() {
		return this.netContent != null && !this.netContent.isEmpty();
	}
	
	public InventoryItem setNetContent(Quantity value) {
		this.netContent = value;
		return this;
	}
	
	protected void listChildren(List<Property> children) {
		super.listChildren(children);
		children.add(new Property("identifier", "Identifier", "Business identifier for the inventory item.", 0,
		        Integer.MAX_VALUE, this.identifier));
		children.add(new Property("status", "code", "Status of the item entry.", 0, 1, this.status));
		children.add(new Property("category", "CodeableConcept", "Category or class of the item.", 0, Integer.MAX_VALUE,
		        this.category));
		children.add(new Property("code", "CodeableConcept", "Code designating the specific type of item.", 0,
		        Integer.MAX_VALUE, this.code));
		children.add(
		    new Property("name", "", "The item name(s) - the brand name, or common name, functional name, generic name.", 0,
		            Integer.MAX_VALUE, this.name));
		children.add(new Property("description", "", "The descriptive characteristics of the inventory item.", 0, 1,
		        this.description));
		children.add(new Property("inventoryStatus", "CodeableConcept",
		        "The usage status e.g. recalled, in use, discarded... This can be used to indicate that the items have been taken out of inventory, or are in use, etc.",
		        0, Integer.MAX_VALUE, this.inventoryStatus));
		children.add(new Property("baseUnit", "CodeableConcept",
		        "The base unit of measure - the unit in which the product is used or counted.", 0, 1, this.baseUnit));
		children.add(
		    new Property("netContent", "Quantity", "Net content or amount present in the item.", 0, 1, this.netContent));
	}
	
	public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
		switch (_hash) {
			case -1724546052:
				return new Property("description", "", "The descriptive characteristics of the inventory item.", 0, 1,
				        this.description);
			case -1721465867:
				return new Property("baseUnit", "CodeableConcept",
				        "The base unit of measure - the unit in which the product is used or counted.", 0, 1, this.baseUnit);
			case -1618432855:
				return new Property("identifier", "Identifier", "Business identifier for the inventory item.", 0,
				        Integer.MAX_VALUE, this.identifier);
			case -1370922898:
				return new Property("inventoryStatus", "CodeableConcept",
				        "The usage status e.g. recalled, in use, discarded... This can be used to indicate that the items have been taken out of inventory, or are in use, etc.",
				        0, Integer.MAX_VALUE, this.inventoryStatus);
			case -892481550:
				return new Property("status", "code", "Status of the item entry.", 0, 1, this.status);
			case 3059181:
				return new Property("code", "CodeableConcept", "Code designating the specific type of item.", 0,
				        Integer.MAX_VALUE, this.code);
			case 3373707:
				return new Property("name", "",
				        "The item name(s) - the brand name, or common name, functional name, generic name.", 0,
				        Integer.MAX_VALUE, this.name);
			case 50511102:
				return new Property("category", "CodeableConcept", "Category or class of the item.", 0, Integer.MAX_VALUE,
				        this.category);
			case 612796444:
				return new Property("netContent", "Quantity", "Net content or amount present in the item.", 0, 1,
				        this.netContent);
			default:
				return super.getNamedProperty(_hash, _name, _checkValid);
		}
	}
	
	public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
		switch (hash) {
			case -1724546052:
				return this.description == null ? new Base[0] : new Base[] { this.description };
			case -1721465867:
				return this.baseUnit == null ? new Base[0] : new Base[] { this.baseUnit };
			case -1618432855:
				return this.identifier == null ? new Base[0]
				        : (Base[]) this.identifier.toArray(new Base[this.identifier.size()]);
			case -1370922898:
				return this.inventoryStatus == null ? new Base[0]
				        : (Base[]) this.inventoryStatus.toArray(new Base[this.inventoryStatus.size()]);
			case -892481550:
				return this.status == null ? new Base[0] : new Base[] { this.status };
			case 3059181:
				return this.code == null ? new Base[0] : (Base[]) this.code.toArray(new Base[this.code.size()]);
			case 3373707:
				return this.name == null ? new Base[0] : (Base[]) this.name.toArray(new Base[this.name.size()]);
			case 50511102:
				return this.category == null ? new Base[0] : (Base[]) this.category.toArray(new Base[this.category.size()]);
			case 612796444:
				return this.netContent == null ? new Base[0] : new Base[] { this.netContent };
			default:
				return super.getProperty(hash, name, checkValid);
		}
	}
	
	public Base setProperty(int hash, String name, Base value) throws FHIRException {
		switch (hash) {
			case -1724546052:
				this.description = (InventoryItemDescriptionComponent) value;
				return value;
			case -1721465867:
				this.baseUnit = castToCodeableConcept(value);
				return value;
			case -1618432855:
				this.getIdentifier().add(castToIdentifier(value));
				return value;
			case -1370922898:
				this.getInventoryStatus().add(castToCodeableConcept(value));
				return value;
			case -892481550:
				Base value1 = (new InventoryItemStatusCodesEnumFactory()).fromType(castToCode(value));
				this.status = (Enumeration) value1;
				return value1;
			case 3059181:
				this.getCode().add(castToCodeableConcept(value));
				return value;
			case 3373707:
				this.getName().add((InventoryItemNameComponent) value);
				return value;
			case 50511102:
				this.getCategory().add(castToCodeableConcept(value));
				return value;
			case 612796444:
				this.netContent = castToQuantity(value);
				return value;
			default:
				return super.setProperty(hash, name, value);
		}
	}
	
	public Base setProperty(String name, Base value) throws FHIRException {
		switch (name) {
			case "identifier":
				this.getIdentifier().add(castToIdentifier((Base) value));
				break;
			case "status":
				value = (new InventoryItemStatusCodesEnumFactory()).fromType(castToCode((Base) value));
				this.status = (Enumeration) value;
				break;
			case "category":
				this.getCategory().add(castToCodeableConcept((Base) value));
				break;
			case "code":
				this.getCode().add(castToCodeableConcept((Base) value));
				break;
			case "name":
				this.getName().add((InventoryItemNameComponent) value);
				break;
			case "description":
				this.description = (InventoryItemDescriptionComponent) value;
				break;
			case "inventoryStatus":
				this.getInventoryStatus().add(castToCodeableConcept((Base) value));
				break;
			case "baseUnit":
				this.baseUnit = castToCodeableConcept((Base) value);
				break;
			case "netContent":
				this.netContent = castToQuantity((Base) value);
				break;
		}
		return (Base) value;
	}
	
	public Base makeProperty(int hash, String name) throws FHIRException {
		switch (hash) {
			case -1724546052:
				return this.getDescription();
			case -1721465867:
				return this.getBaseUnit();
			case -1618432855:
				return this.addIdentifier();
			case -1370922898:
				return this.addInventoryStatus();
			case -892481550:
				return this.getStatusElement();
			case 3059181:
				return this.addCode();
			case 3373707:
				return this.addName();
			case 50511102:
				return this.addCategory();
			case 612796444:
				return this.getNetContent();
			default:
				return super.makeProperty(hash, name);
		}
	}
	
	public String[] getTypesForProperty(int hash, String name) throws FHIRException {
		switch (hash) {
			case -1724546052:
				return new String[0];
			case -1721465867:
				return new String[] { "CodeableConcept" };
			case -1704933559:
				return new String[0];
			case -1618432855:
				return new String[] { "Identifier" };
			case -1370922898:
				return new String[] { "CodeableConcept" };
			case -892481550:
				return new String[] { "code" };
			case -669667556:
				return new String[] { "Reference" };
			case -87499647:
				return new String[0];
			case 3059181:
				return new String[] { "CodeableConcept" };
			case 3373707:
				return new String[0];
			case 50511102:
				return new String[] { "CodeableConcept" };
			case 366313883:
				return new String[0];
			case 555127957:
				return new String[0];
			case 612796444:
				return new String[] { "Quantity" };
			default:
				return super.getTypesForProperty(hash, name);
		}
	}
	
	public Base addChild(String name) throws FHIRException {
		switch (name) {
			case "identifier":
				return this.addIdentifier();
			case "status":
				throw new FHIRException("Cannot call addChild on a singleton property InventoryItem.status");
			case "category":
				return this.addCategory();
			case "code":
				return this.addCode();
			case "name":
				return this.addName();
			case "description":
				this.description = new InventoryItemDescriptionComponent();
				return this.description;
			case "inventoryStatus":
				return this.addInventoryStatus();
			case "baseUnit":
				this.baseUnit = new CodeableConcept();
				return this.baseUnit;
			case "netContent":
				this.netContent = new Quantity();
				return this.netContent;
			default:
				return super.addChild(name);
		}
	}
	
	public String fhirType() {
		return "InventoryItem";
	}
	
	public InventoryItem copy() {
		InventoryItem dst = new InventoryItem();
		this.copyValues(dst);
		return dst;
	}
	
	public void copyValues(InventoryItem dst) {
		super.copyValues(dst);
		Iterator var2;
		if (this.identifier != null) {
			dst.identifier = new ArrayList();
			var2 = this.identifier.iterator();
			
			while (var2.hasNext()) {
				Identifier i = (Identifier) var2.next();
				dst.identifier.add(i.copy());
			}
		}
		
		dst.status = this.status == null ? null : this.status.copy();
		CodeableConcept i;
		if (this.category != null) {
			dst.category = new ArrayList();
			var2 = this.category.iterator();
			
			while (var2.hasNext()) {
				i = (CodeableConcept) var2.next();
				dst.category.add(i.copy());
			}
		}
		
		if (this.code != null) {
			dst.code = new ArrayList();
			var2 = this.code.iterator();
			
			while (var2.hasNext()) {
				i = (CodeableConcept) var2.next();
				dst.code.add(i.copy());
			}
		}
		
		if (this.name != null) {
			dst.name = new ArrayList();
			var2 = this.name.iterator();
			
			while (var2.hasNext()) {
				InventoryItemNameComponent inventoryItemNameComponent = (InventoryItemNameComponent) var2.next();
				dst.name.add(inventoryItemNameComponent.copy());
			}
		}
		
		dst.description = this.description == null ? null : this.description.copy();
		if (this.inventoryStatus != null) {
			dst.inventoryStatus = new ArrayList();
			var2 = this.inventoryStatus.iterator();
			
			while (var2.hasNext()) {
				i = (CodeableConcept) var2.next();
				dst.inventoryStatus.add(i.copy());
			}
		}
		
		dst.baseUnit = this.baseUnit == null ? null : this.baseUnit.copy();
		dst.netContent = this.netContent == null ? null : this.netContent.copy();
	}
	
	protected InventoryItem typedCopy() {
		return this.copy();
	}
	
	public boolean equalsDeep(Base other_) {
		if (!super.equalsDeep(other_)) {
			return false;
		} else if (!(other_ instanceof InventoryItem)) {
			return false;
		} else {
			InventoryItem o = (InventoryItem) other_;
			return compareDeep(this.identifier, o.identifier, true) && compareDeep(this.status, o.status, true)
			        && compareDeep(this.category, o.category, true) && compareDeep(this.code, o.code, true)
			        && compareDeep(this.name, o.name, true) && compareDeep(this.description, o.description, true)
			        && compareDeep(this.inventoryStatus, o.inventoryStatus, true)
			        && compareDeep(this.baseUnit, o.baseUnit, true) && compareDeep(this.netContent, o.netContent, true);
		}
	}
	
	public boolean equalsShallow(Base other_) {
		if (!super.equalsShallow(other_)) {
			return false;
		} else if (!(other_ instanceof InventoryItem)) {
			return false;
		} else {
			InventoryItem o = (InventoryItem) other_;
			return compareValues(this.status, o.status, true);
		}
	}
	
	public boolean isEmpty() {
		return super.isEmpty() && ElementUtil.isEmpty(new Object[] { this.identifier, this.status, this.category, this.code,
		        this.name, this.description, this.inventoryStatus, this.baseUnit, this.netContent });
	}
	
	public ResourceType getResourceType() {
		return null;
	}
	
	@Block
	public static class InventoryItemDescriptionComponent extends BackboneElement implements IBaseBackboneElement {
		
		@Child(name = "description", type = {
		        StringType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
		@Description(shortDefinition = "Textual description of the item", formalDefinition = "Textual description of the item.")
		protected StringType description;
		
		private static final long serialVersionUID = -803271414L;
		
		public InventoryItemDescriptionComponent() {
		}
		
		public StringType getDescriptionElement() {
			if (this.description == null) {
				if (Configuration.errorOnAutoCreate()) {
					throw new Error("Attempt to auto-create InventoryItemDescriptionComponent.description");
				}
				
				if (Configuration.doAutoCreate()) {
					this.description = new StringType();
				}
			}
			
			return this.description;
		}
		
		public boolean hasDescriptionElement() {
			return this.description != null && !this.description.isEmpty();
		}
		
		public boolean hasDescription() {
			return this.description != null && !this.description.isEmpty();
		}
		
		public InventoryItemDescriptionComponent setDescriptionElement(StringType value) {
			this.description = value;
			return this;
		}
		
		public String getDescription() {
			return this.description == null ? null : (String) this.description.getValue();
		}
		
		public InventoryItemDescriptionComponent setDescription(String value) {
			if (Utilities.noString(value)) {
				this.description = null;
			} else {
				if (this.description == null) {
					this.description = new StringType();
				}
				
				this.description.setValue(value);
			}
			
			return this;
		}
		
		protected void listChildren(List<Property> children) {
			super.listChildren(children);
			children.add(new Property("description", "string", "Textual description of the item.", 0, 1, this.description));
		}
		
		public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
			if (_hash == -1724546052) {
				return new Property("description", "string", "Textual description of the item.", 0, 1, this.description);
			}
			return super.getNamedProperty(_hash, _name, _checkValid);
		}
		
		public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
			if (hash == -1724546052) {
				return this.description == null ? new Base[0] : new Base[] { this.description };
			}
			return super.getProperty(hash, name, checkValid);
		}
		
		public Base setProperty(int hash, String name, Base value) throws FHIRException {
			if (hash == -1724546052) {
				this.description = castToString(value);
				return value;
			}
			return super.setProperty(hash, name, value);
		}
		
		public Base setProperty(String name, Base value) throws FHIRException {
			if (!name.equals("description")) {
				return super.setProperty(name, (Base) value);
			}
			this.description = castToString((Base) value);
			return (Base) value;
		}
		
		public Base makeProperty(int hash, String name) throws FHIRException {
			if (hash == -1724546052) {
				return this.getDescriptionElement();
			}
			return super.makeProperty(hash, name);
		}
		
		public String[] getTypesForProperty(int hash, String name) throws FHIRException {
			switch (hash) {
				case -1724546052:
					return new String[] { "string" };
				case -1613589672:
					return new String[] { "code" };
				default:
					return super.getTypesForProperty(hash, name);
			}
		}
		
		public Base addChild(String name) throws FHIRException {
			if (name.equals("description")) {
				throw new FHIRException(
				        "Cannot call addChild on a singleton property InventoryItem.description.description");
			} else {
				return super.addChild(name);
			}
		}
		
		public InventoryItemDescriptionComponent copy() {
			InventoryItemDescriptionComponent dst = new InventoryItemDescriptionComponent();
			this.copyValues(dst);
			return dst;
		}
		
		public void copyValues(InventoryItemDescriptionComponent dst) {
			super.copyValues(dst);
			dst.description = this.description == null ? null : this.description.copy();
		}
		
		public boolean equalsDeep(Base other_) {
			if (!super.equalsDeep(other_)) {
				return false;
			} else if (!(other_ instanceof InventoryItemDescriptionComponent)) {
				return false;
			} else {
				InventoryItemDescriptionComponent o = (InventoryItemDescriptionComponent) other_;
				return compareDeep(this.description, o.description, true);
			}
		}
		
		public boolean equalsShallow(Base other_) {
			if (!super.equalsShallow(other_)) {
				return false;
			} else if (!(other_ instanceof InventoryItemDescriptionComponent)) {
				return false;
			} else {
				InventoryItemDescriptionComponent o = (InventoryItemDescriptionComponent) other_;
				return compareValues(this.description, o.description, true);
			}
		}
		
		public boolean isEmpty() {
			return super.isEmpty() && ElementUtil.isEmpty(new IElement[] { this.description });
		}
		
		public String fhirType() {
			return "InventoryItem.description";
		}
	}
	
	@Block
	public static class InventoryItemNameComponent extends BackboneElement implements IBaseBackboneElement {
		
		@Child(name = "nameType", type = { Coding.class }, order = 1, min = 1, max = 1, modifier = false, summary = true)
		@Description(shortDefinition = "The type of name e.g. 'brand-name', 'functional-name', 'common-name'", formalDefinition = "The type of name e.g. 'brand-name', 'functional-name', 'common-name'.")
		@Binding(valueSet = "http://hl7.org/fhir/ValueSet/inventoryitem-nametype")
		protected Coding nameType;
		
		@Child(name = "name", type = { StringType.class }, order = 3, min = 1, max = 1, modifier = false, summary = true)
		@Description(shortDefinition = "The name or designation of the item", formalDefinition = "The name or designation that the item is given.")
		protected StringType name;
		
		private static final long serialVersionUID = 2074178414L;
		
		public InventoryItemNameComponent() {
		}
		
		public InventoryItemNameComponent(Coding nameType, String name) {
			this.setNameType(nameType);
			this.setName(name);
		}
		
		public Coding getNameType() {
			if (this.nameType == null) {
				if (Configuration.errorOnAutoCreate()) {
					throw new Error("Attempt to auto-create InventoryItemNameComponent.nameType");
				}
				
				if (Configuration.doAutoCreate()) {
					this.nameType = new Coding();
				}
			}
			
			return this.nameType;
		}
		
		public boolean hasNameType() {
			return this.nameType != null && !this.nameType.isEmpty();
		}
		
		public InventoryItemNameComponent setNameType(Coding value) {
			this.nameType = value;
			return this;
		}
		
		public StringType getNameElement() {
			if (this.name == null) {
				if (Configuration.errorOnAutoCreate()) {
					throw new Error("Attempt to auto-create InventoryItemNameComponent.name");
				}
				
				if (Configuration.doAutoCreate()) {
					this.name = new StringType();
				}
			}
			
			return this.name;
		}
		
		public boolean hasNameElement() {
			return this.name != null && !this.name.isEmpty();
		}
		
		public boolean hasName() {
			return this.name != null && !this.name.isEmpty();
		}
		
		public InventoryItemNameComponent setNameElement(StringType value) {
			this.name = value;
			return this;
		}
		
		public String getName() {
			return this.name == null ? null : (String) this.name.getValue();
		}
		
		public InventoryItemNameComponent setName(String value) {
			if (this.name == null) {
				this.name = new StringType();
			}
			
			this.name.setValue(value);
			return this;
		}
		
		protected void listChildren(List<Property> children) {
			super.listChildren(children);
			children.add(new Property("nameType", "Coding",
			        "The type of name e.g. 'brand-name', 'functional-name', 'common-name'.", 0, 1, this.nameType));
			children.add(new Property("name", "string", "The name or designation that the item is given.", 0, 1, this.name));
		}
		
		public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
			switch (_hash) {
				case 3373707:
					return new Property("name", "string", "The name or designation that the item is given.", 0, 1,
					        this.name);
				case 1840595045:
					return new Property("nameType", "Coding",
					        "The type of name e.g. 'brand-name', 'functional-name', 'common-name'.", 0, 1, this.nameType);
				default:
					return super.getNamedProperty(_hash, _name, _checkValid);
			}
		}
		
		public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
			switch (hash) {
				case 3373707:
					return this.name == null ? new Base[0] : new Base[] { this.name };
				case 1840595045:
					return this.nameType == null ? new Base[0] : new Base[] { this.nameType };
				default:
					return super.getProperty(hash, name, checkValid);
			}
		}
		
		public Base setProperty(int hash, String name, Base value) throws FHIRException {
			switch (hash) {
				case 3373707:
					this.name = castToString(value);
					return value;
				case 1840595045:
					this.nameType = castToCoding(value);
					return value;
				default:
					return super.setProperty(hash, name, value);
			}
		}
		
		public Base setProperty(String name, Base value) throws FHIRException {
			if (name.equals("nameType")) {
				this.nameType = castToCoding((Base) value);
			} else {
				if (!name.equals("name")) {
					return super.setProperty(name, (Base) value);
				}
				
				this.name = castToString((Base) value);
			}
			
			return (Base) value;
		}
		
		public Base makeProperty(int hash, String name) throws FHIRException {
			switch (hash) {
				case 3373707:
					return this.getNameElement();
				case 1840595045:
					return this.getNameType();
				default:
					return super.makeProperty(hash, name);
			}
		}
		
		public String[] getTypesForProperty(int hash, String name) throws FHIRException {
			switch (hash) {
				case -1613589672:
					return new String[] { "code" };
				case 3373707:
					return new String[] { "string" };
				case 1840595045:
					return new String[] { "Coding" };
				default:
					return super.getTypesForProperty(hash, name);
			}
		}
		
		public Base addChild(String name) throws FHIRException {
			if (name.equals("nameType")) {
				this.nameType = new Coding();
				return this.nameType;
			} else if (name.equals("name")) {
				throw new FHIRException("Cannot call addChild on a singleton property InventoryItem.name.name");
			} else {
				return super.addChild(name);
			}
		}
		
		public InventoryItemNameComponent copy() {
			InventoryItemNameComponent dst = new InventoryItemNameComponent();
			this.copyValues(dst);
			return dst;
		}
		
		public void copyValues(InventoryItemNameComponent dst) {
			super.copyValues(dst);
			dst.nameType = this.nameType == null ? null : this.nameType.copy();
			dst.name = this.name == null ? null : this.name.copy();
		}
		
		public boolean equalsDeep(Base other_) {
			if (!super.equalsDeep(other_)) {
				return false;
			} else if (!(other_ instanceof InventoryItemNameComponent)) {
				return false;
			} else {
				InventoryItemNameComponent o = (InventoryItemNameComponent) other_;
				return compareDeep(this.nameType, o.nameType, true) && compareDeep(this.name, o.name, true);
			}
		}
		
		public boolean equalsShallow(Base other_) {
			if (!super.equalsShallow(other_)) {
				return false;
			} else if (!(other_ instanceof InventoryItemNameComponent)) {
				return false;
			} else {
				InventoryItemNameComponent o = (InventoryItemNameComponent) other_;
				return compareValues(this.name, o.name, true);
			}
		}
		
		public boolean isEmpty() {
			return super.isEmpty() && ElementUtil.isEmpty(new IElement[] { this.nameType, this.name });
		}
		
		public String fhirType() {
			return "InventoryItem.name";
		}
	}
	
	public static class InventoryItemStatusCodesEnumFactory implements EnumFactory<InventoryItemStatusCodes> {
		
		public InventoryItemStatusCodesEnumFactory() {
		}
		
		public InventoryItemStatusCodes fromCode(String codeString) throws IllegalArgumentException {
			if (codeString != null && !codeString.isEmpty()) {
				switch (codeString) {
					case "active":
						return InventoryItemStatusCodes.ACTIVE;
					case "inactive":
						return InventoryItemStatusCodes.INACTIVE;
					case "entered-in-error":
						return InventoryItemStatusCodes.ENTEREDINERROR;
					case "unknown":
						return InventoryItemStatusCodes.UNKNOWN;
					default:
						throw new IllegalArgumentException("Unknown InventoryItemStatusCodes code '" + codeString + "'");
				}
			} else {
				return null;
			}
		}
		
		public Enumeration<InventoryItemStatusCodes> fromType(PrimitiveType<?> code) throws FHIRException {
			if (code == null) {
				return null;
			} else if (code.isEmpty()) {
				return new Enumeration<>(this, InventoryItem.InventoryItemStatusCodes.NULL);
			} else {
				String codeString = code.asStringValue();
				if (codeString != null && !codeString.isEmpty()) {
					switch (codeString) {
						case "active":
							return new Enumeration<>(this, InventoryItemStatusCodes.ACTIVE);
						case "inactive":
							return new Enumeration<>(this, InventoryItemStatusCodes.INACTIVE);
						case "entered-in-error":
							return new Enumeration<>(this, InventoryItemStatusCodes.ENTEREDINERROR);
						case "unknown":
							return new Enumeration<>(this, InventoryItemStatusCodes.UNKNOWN);
						default:
							throw new FHIRException("Unknown InventoryItemStatusCodes code '" + codeString + "'");
					}
				} else {
					return new Enumeration<>(this, InventoryItem.InventoryItemStatusCodes.NULL);
				}
			}
		}
		
		public String toCode(InventoryItemStatusCodes code) {
			if (code == InventoryItem.InventoryItemStatusCodes.ACTIVE) {
				return "active";
			} else if (code == InventoryItem.InventoryItemStatusCodes.INACTIVE) {
				return "inactive";
			} else if (code == InventoryItem.InventoryItemStatusCodes.ENTEREDINERROR) {
				return "entered-in-error";
			} else {
				return code == InventoryItem.InventoryItemStatusCodes.UNKNOWN ? "unknown" : "?";
			}
		}
		
		public String toSystem(InventoryItemStatusCodes code) {
			return code.getSystem();
		}
	}
	
	public static enum InventoryItemStatusCodes {
		
		ACTIVE,
		INACTIVE,
		ENTEREDINERROR,
		UNKNOWN,
		NULL;
		
		private InventoryItemStatusCodes() {
		}
		
		public static InventoryItemStatusCodes fromCode(String codeString) throws FHIRException {
			if (codeString != null && !"".equals(codeString)) {
				if ("active".equals(codeString)) {
					return ACTIVE;
				} else if ("inactive".equals(codeString)) {
					return INACTIVE;
				} else if ("entered-in-error".equals(codeString)) {
					return ENTEREDINERROR;
				} else if ("unknown".equals(codeString)) {
					return UNKNOWN;
				} else if (Configuration.isAcceptInvalidEnums()) {
					return null;
				} else {
					throw new FHIRException("Unknown InventoryItemStatusCodes code '" + codeString + "'");
				}
			} else {
				return null;
			}
		}
		
		public String toCode() {
			switch (this) {
				case ACTIVE:
					return "active";
				case INACTIVE:
					return "inactive";
				case ENTEREDINERROR:
					return "entered-in-error";
				case UNKNOWN:
					return "unknown";
				case NULL:
					return null;
				default:
					return "?";
			}
		}
		
		public String getSystem() {
			switch (this) {
				case ACTIVE:
					return "http://hl7.org/fhir/inventoryitem-status";
				case INACTIVE:
					return "http://hl7.org/fhir/inventoryitem-status";
				case ENTEREDINERROR:
					return "http://hl7.org/fhir/inventoryitem-status";
				case UNKNOWN:
					return "http://hl7.org/fhir/inventoryitem-status";
				case NULL:
					return null;
				default:
					return "?";
			}
		}
		
		public String getDefinition() {
			switch (this) {
				case ACTIVE:
					return "The item is active and can be referenced.";
				case INACTIVE:
					return "The item is presently inactive - there may be references to it but the item is not expected to be used.";
				case ENTEREDINERROR:
					return "The item record was entered in error.";
				case UNKNOWN:
					return "The item status has not been determined.";
				case NULL:
					return null;
				default:
					return "?";
			}
		}
		
		public String getDisplay() {
			switch (this) {
				case ACTIVE:
					return "Active";
				case INACTIVE:
					return "Inactive";
				case ENTEREDINERROR:
					return "Entered in Error";
				case UNKNOWN:
					return "Unknown";
				case NULL:
					return null;
				default:
					return "?";
			}
		}
	}
}
