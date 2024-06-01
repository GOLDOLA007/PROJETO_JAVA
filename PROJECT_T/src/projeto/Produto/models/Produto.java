package projeto.Produto.models;

import java.util.ArrayList;

public class Produto {
	private String category, type, description;
	private double price;
	private int id;

	public Produto() {

	}

	public Produto(String category, String type, String description, int id, double price) {
		this.category = category;
		this.type = type;
		this.description = description;
		this.price = price;
		this.id = id;
	}

	// DESCRIPTION
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	// PRICE
	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	// ID
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	// TYPE
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	// CATEGORY
	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "==============DADOS-PRODUTO==============\n" + "Categoria: " + category + "\n" + "Tipo: " + type + "\n"
				+ "ID: " + id + "\n" + "Preço: " + price + "\n" + "Descrição: " + description;
	}

	public String viewData() {
		return toString();
	}

}
