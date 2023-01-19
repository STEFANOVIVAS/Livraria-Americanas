
//Algumas funcionalidades do sistema:
// Você deve ser capaz de adicionar, ver, alterar e remover qualquer produto do sistema.
// Você deve ser capaz de ver quantos itens de um tipo específico existem no estoque.
// Você deve ser capaz de ver a listagem completa dos itens em estoque.
// Você deve ser capaz de ver a listagem dos itens em estoque por categoria.
// Você deve ser capaz de realizar a operação de compra,
// ao realizar esta operação os produtos comprados são removidos do estoque e o dinheiro pago deve ser adicionado ao caixa


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Livraria {
    private List<Produto> produtos= new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in).useDelimiter("\\n");
        AlbumMusica album = new AlbumMusica("Secos e molhados", 35.5, "MPB", "Secos e molhados", "EMI");
        AlbumMusica album2 = new AlbumMusica("revolta dos dandis", 40.5, "Rock", "Engenheiros do Hawai", "EMI");
        Livro livro = new Livro("Habitos Atomicos", 44.5, "Produtividade", "Carlos tiher", "Cia das letras");
        Brinquedo brinquedo = new Brinquedo("Pula Pula", 40.5, "Bonecos");

        Jogo jogo = new Jogo("Jogos de verão",23.5,"EA Sports","Esportes","EA Sports");
        Filme filme = new Filme("Revolta dos dandis", 424.5, "Cris Rock", "Ação", "Warner","tesxtor faith");

        System.out.println(album);
        System.out.println(album2);
        System.out.println(livro);
        System.out.println(brinquedo);
        System.out.println(jogo);
        System.out.println(filme);

        


       /* Livraria livraria=new Livraria();
        livraria.menuInciar(sc);*/

    }

    public void menuInciar(Scanner sc) {


        System.out.println("***********************************************************************");
        System.out.println("************   Bem-vindo a Livraria Americanas   **********************");
        System.out.println("***********************************************************************");
        System.out.println("************             Menu Inicial            **********************");
        System.out.println("***********************************************************************");


        System.out.println("****   Digite o número 1 para Acessar o gerenciador de estoque.   *****");
        System.out.println("****   Digite o número 2 para Consultar o estoque de um produto.  *****");
        System.out.println("****   Digite o número 3 para Consultar o estoque geral.          *****");
        System.out.println("****   Digite o número 4 para Consultar o estoque por categoria.  *****");
        System.out.println("****   Digite o número 5 para realizar uma compra.                *****");
        System.out.println("***********************************************************************");


        //switch case
        String numeroMenuInicial = sc.next();
        switch (numeroMenuInicial) {
            case ("1") -> acessarMenuGerenciadorEstoque(sc);
          /*  case ("2") -> consultarEstoqueProduto();
            case ("3") -> consultarEstoqueGeral();
            case ("4") -> consultaEstoquePorCategoria();
            case ("5") -> realizarCompra();*/
            default ->throw new IllegalStateException("Erro inesperado" + numeroMenuInicial);



        }




    }

    public void acessarMenuGerenciadorEstoque(Scanner sc){
        System.out.println("*************       Gerenciador de estoque      ***********************");
        System.out.println("***********************************************************************");
        System.out.println("****   Digite o número 1 para Adicionar um produto.               *****");
        System.out.println("****   Digite o número 2 para Consultar um produto.               *****");
        System.out.println("****   Digite o número 3 para Alterar um produto.                 *****");
        System.out.println("****   Digite o número 4 para Remover um produto.                 *****");
        System.out.println("****   Digite o número 5 para retornar ao Menu Inicial.           *****");
        System.out.println("***********************************************************************");

        String numeroMenuGerenciadorEstoque = sc.next();
        switch (numeroMenuGerenciadorEstoque) {
            case ("1") -> acessarMenuAdicionarProduto(sc);
           /* case ("2") -> consultarEstoqueProduto();
            case ("3") -> consultarEstoqueGeral();
            case ("4") -> consultaEstoquePorCategoria();
            case ("5") -> realizarCompra();*/
            default ->throw new IllegalStateException("Erro inesperado" + numeroMenuGerenciadorEstoque);



        }

    }
    public void acessarMenuAdicionarProduto(Scanner sc){
        System.out.println("*************         Adicionar Produto         ***********************");
        System.out.println("***********************************************************************");
        System.out.println("****   Digite o número 1 para Adicionar um Album de música.       *****");
        System.out.println("****   Digite o número 2 para Adicionar um Brinquedo.             *****");
        System.out.println("****   Digite o número 3 para Adicionar um Filme.                 *****");
        System.out.println("****   Digite o número 4 para Adicionar um Jogo.                  *****");
        System.out.println("****   Digite o número 5 para Adicionar um Livro.                 *****");
        System.out.println("****   Digite o número 6 para Retornar ao gerenciador de Estoque. *****");
        System.out.println("***********************************************************************");
        String numeroMenuAdicionarProduto = sc.next();
        switch (numeroMenuAdicionarProduto) {
            case ("1") -> adicionarAlbum(sc);
            case ("2") -> adicionarBrinquedo(sc);
            case ("3") -> adicionarFilme(sc);
            case ("4") -> adicionarJogo(sc);
            case ("5") -> adicionarLivro(sc);
            default ->throw new IllegalStateException("Erro inesperado" + numeroMenuAdicionarProduto);



        }


    }
    public void adicionarAlbum(Scanner sc){
        System.out.println("Digite o nome do Albúm:");
        String nome=sc.next();

        System.out.println("Digite o preco do Albúm:");
        String precoString=sc.next();
        Double preco=Double.valueOf(precoString);

        System.out.println("Digite o nome do genero:");
        String genero=sc.next();

        System.out.println("Digite o nome da Banda:");
        String banda=sc.next();

        System.out.println("Digite o nome do Selo:");
        String selo=sc.next();

        AlbumMusica album=new AlbumMusica(nome,preco,genero,banda,selo);
        produtos.add(album);
        System.out.println(produtos);
        acessarMenuGerenciadorEstoque(sc);

    }
    public void adicionarBrinquedo(Scanner sc){
        System.out.println("Digite o nome do Brinquedo:");
        String nome=sc.next();

        System.out.println("Digite o preco do Brinquedo:");
        String precoString=sc.next();
        Double preco=Double.valueOf(precoString);

        System.out.println("Digite o tipo do Brinquedo:");
        String tipoBrinquedo=sc.next();

        Brinquedo brinquedo=new Brinquedo(nome,preco,tipoBrinquedo);
        produtos.add(brinquedo);
        System.out.println(produtos);
        acessarMenuGerenciadorEstoque(sc);

    }
    public void adicionarFilme(Scanner sc){
        System.out.println("Digite o nome do Filme:");
        String nome=sc.next();

        System.out.println("Digite o preco do Filme:");
        String precoString=sc.next();
        Double preco=Double.valueOf(precoString);

        System.out.println("Digite o nome do Genero do Filme:");
        String genero=sc.next();

        System.out.println("Digite o nome do Diretor do Filme:");
        String diretor=sc.next();

        System.out.println("Digite o nome do Produto do Filme:");
        String produtor=sc.next();

        System.out.println("Digite o nome do Filme:");
        String estudio=sc.next();

        Filme filme=new Filme(nome,preco,diretor,genero,estudio,produtor);
        produtos.add(filme);
        System.out.println(produtos);
        acessarMenuGerenciadorEstoque(sc);
    }
    public void adicionarJogo(Scanner sc){

        System.out.println("Digite o nome do Jogo:");
        String nome=sc.next();

        System.out.println("Digite o preco do Jogo:");
        String precoString=sc.next();
        Double preco=Double.valueOf(precoString);

        System.out.println("Digite o nome da Distribuidora do Jogo:");
        String distribuidora=sc.next();

        System.out.println("Digite o nome do Genero do Jogo:");
        String genero=sc.next();

        System.out.println("Digite o nome do Estúdio do jogo:");
        String estudio=sc.next();

        Jogo jogo=new Jogo(nome,preco,distribuidora,genero,estudio);
        produtos.add(jogo);
        System.out.println(produtos);
        acessarMenuGerenciadorEstoque(sc);

    }
    public void adicionarLivro(Scanner sc){

        System.out.println("Digite o nome do Livro:");
        String nome=sc.next();

        System.out.println("Digite o preco do Livro:");
        String precoString=sc.next();
        Double preco=Double.valueOf(precoString);

        System.out.println("Digite o nome do Genero do Livro:");
        String genero=sc.next();

        System.out.println("Digite o nome do escritor do Livro:");
        String escritor=sc.next();

        System.out.println("Digite o nome da editora do Livro:");
        String editora=sc.next();

        Livro livro=new Livro(nome,preco,genero,escritor,editora);
        produtos.add(livro);
        System.out.println(produtos);
        acessarMenuGerenciadorEstoque(sc);


    }

}
