package com.teste.aula_1.view.model;

public class ProductRequest {
    // #region Atributos

    private String name;

    private Integer quantity;

    private Double value;

    private String description;

    // #endregion

    // #region getandsatters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // #endregion getandsetters

}
