package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;


public class CarrinhoDeCompras {
    private List<Item> itensCarrinho;

    public CarrinhoDeCompras() {
        this.itensCarrinho = new ArrayList<>();
        }

    public void adicionarItem(String nome, double preco, int quantidade) {
        itensCarrinho.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!itensCarrinho.isEmpty()) {
            for (Item i: itensCarrinho) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            itensCarrinho.removeAll(itensParaRemover);
        } else {
            System.out.println("O carrinho está vazio!");
        }
    }

    public void exibirItens() {
        if (!itensCarrinho.isEmpty()) {
            System.out.println(itensCarrinho);
        } else {
            System.out.println("O carrinho está vazio!");
        }
    }


    public Double calcularValorTotal() {
        return itensCarrinho.stream()
                .mapToDouble(Item -> Item.getPreco())
                .sum();
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Leite", 2.99, 1);
        carrinhoDeCompras.adicionarItem("Chocolate", 2.99, 1);
        System.out.println("Valor total: " + carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.removerItem("Leite");
        System.out.println("Valor total: " + carrinhoDeCompras.calcularValorTotal());
    }
}


