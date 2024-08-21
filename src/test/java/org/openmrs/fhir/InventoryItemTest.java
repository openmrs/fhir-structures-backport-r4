package org.openmrs.fhir;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Quantity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InventoryItemTest {
	
	private InventoryItem inventoryItem;
	
	@BeforeEach
	void setUp() {
		inventoryItem = new InventoryItem();
	}
	
	@Test
	@DisplayName("Should add identifier")
	void addIdentifier_shouldAddIdentifier() {
		// Setup
		Identifier identifier = new Identifier();
		identifier.setValue("123");
		inventoryItem.addIdentifier(identifier);
		
		// Verify
		assertTrue(inventoryItem.hasIdentifier());
		assertEquals(1, inventoryItem.getIdentifier().size());
		assertEquals(identifier, inventoryItem.getIdentifierFirstRep());
	}
	
	@Test
	@DisplayName("Should set status")
	void setStatus_shouldSetStatus() {
		InventoryItem.InventoryItemStatusCodes status = InventoryItem.InventoryItemStatusCodes.ACTIVE;
		inventoryItem.setStatus(status);
		
		// Verify
		assertTrue(inventoryItem.hasStatus());
		assertEquals(status, inventoryItem.getStatus());
	}
	
	@Test
	@DisplayName("Should add category")
	void addCategory_shouldAddCategory() {
		// Setup
		CodeableConcept category = new CodeableConcept();
		category.setText("category");
		inventoryItem.addCategory(category);
		
		// Verify
		assertTrue(inventoryItem.hasCategory());
		assertEquals(1, inventoryItem.getCategory().size());
		assertEquals(category, inventoryItem.getCategoryFirstRep());
	}
	
	@Test
	@DisplayName("Should add code")
	void addCode_shouldAddCode() {
		// Setup
		CodeableConcept code = new CodeableConcept();
		code.setText("code");
		inventoryItem.addCode(code);
		
		// Verify
		assertTrue(inventoryItem.hasCode());
		assertEquals(1, inventoryItem.getCode().size());
		assertEquals(code, inventoryItem.getCodeFirstRep());
	}
	
	@Test
	@DisplayName("Should set BaseUnit")
	void setBaseUnit_shouldSetBaseUnit() {
		// Setup
		CodeableConcept baseUnit = new CodeableConcept();
		baseUnit.setText("baseUnit");
		inventoryItem.setBaseUnit(baseUnit);
		
		// Verify
		assertTrue(inventoryItem.hasBaseUnit());
		assertEquals(baseUnit, inventoryItem.getBaseUnit());
	}
	
	@Test
	@DisplayName("Should set NetContent")
	void setNetContent_shouldSetNetContent() {
		// Setup
		Quantity netContent = new Quantity();
		netContent.setValue(1);
		netContent.setUnit("unit");
		inventoryItem.setNetContent(netContent);
		
		// Verify
		assertTrue(inventoryItem.hasNetContent());
		assertEquals(netContent, inventoryItem.getNetContent());
	}
	
	@Test
	@DisplayName("Should set InventoryStatus")
	void setInventoryStatus_shouldSetInventoryStatus() {
		// Setup
		CodeableConcept inventoryStatus = new CodeableConcept();
		inventoryStatus.setText("inventoryStatus");
		inventoryItem.setInventoryStatus(Arrays.asList(inventoryStatus));
		
		// Verify
		assertTrue(inventoryItem.hasInventoryStatus());
		assertEquals(inventoryStatus, inventoryItem.getInventoryStatus().get(0));
	}
	
	@Test
	@DisplayName("Should set name")
	void setName_shouldSetName() {
		// Setup
		InventoryItem.InventoryItemNameComponent nameComponent = new InventoryItem.InventoryItemNameComponent();
		nameComponent.setName("name");
		inventoryItem.addName(nameComponent);
		
		// Verify
		assertTrue(inventoryItem.hasName());
		assertEquals(1, inventoryItem.getName().size());
		assertEquals(nameComponent, inventoryItem.getNameFirstRep());
	}
	
	@Test
	@DisplayName("Should set description")
	void setDescription_shouldSetDescription() {
		// Setup
		InventoryItem.InventoryItemDescriptionComponent descriptionComponent = new InventoryItem.InventoryItemDescriptionComponent();
		descriptionComponent.setDescription("description");
		inventoryItem.setDescription(descriptionComponent);
		
		// Verify
		assertTrue(inventoryItem.hasDescription());
		assertEquals(descriptionComponent, inventoryItem.getDescription());
	}
	
	@Test
	@DisplayName("should return true when empty")
	void isEmpty_shouldReturnTrueWhenEmpty() {
		assertTrue(inventoryItem.isEmpty());
	}
	
	@Test
	@DisplayName("should return false when not empty")
	void isEmpty_shouldReturnFalseWhenNotEmpty() {
		// Setup
		inventoryItem.addIdentifier(new Identifier().setValue("123"));
		
		// Verify
		assertFalse(inventoryItem.isEmpty());
	}
}
