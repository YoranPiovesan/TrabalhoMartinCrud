package com.dao;

import java.sql.Date;
import java.util.List;

import com.entity.Produto;

public class ProdutoDao {
	
	public Produto inserirDados(Produto produto) {
		Produto produtoInserir  = new Produto();
		produtoInserir.setNome(produto.getNome());
		produtoInserir.setPreco(produto.getPreco());
		produtoInserir.setTipo(produto.getTipo());
		return produtoInserir;
	}
	
	
	public Produto findByNome(String nome, List<Produto> listaProduto) {
		for (int i = 0; i < listaProduto.size(); i++) {
			if(listaProduto.get(i).getNome().equals(nome)) {
				return listaProduto.get(i);
			}
		}
		return null;
	}
	public void Alterar(Produto produto, String nome, List<Produto> listaProduto) {
		for (int i = 0; i < listaProduto.size(); i++) {
			if(listaProduto.get(i).getNome().equals(nome)) {
				listaProduto.set(i, produto);
			}
		}
	}
	public void Deletar(String nome, List<Produto> listaProduto) {
		for (int i = 0; i < listaProduto.size(); i++) {
			if(listaProduto.get(i).getNome().equals(nome)) {
				listaProduto.remove(i);
			}
		}
	}
}