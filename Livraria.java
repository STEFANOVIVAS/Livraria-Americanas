
//Algumas funcionalidades do sistema:
// Você deve ser capaz de adicionar, ver, alterar e remover qualquer produto do sistema.
// Você deve ser capaz de ver quantos itens de um tipo específico existem no estoque.
// Você deve ser capaz de ver a listagem completa dos itens em estoque.
// Você deve ser capaz de ver a listagem dos itens em estoque por categoria.
// Você deve ser capaz de realizar a operação de compra,
// ao realizar esta operação os produtos comprados são removidos do estoque e o dinheiro pago deve ser adicionado ao caixa


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Livraria {
    private List<Produto> produtos= new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in).useDelimiter("\\n");
       /* AlbumMusica album = new AlbumMusica("Secos e molhados", 35.5, "MPB", "Secos e molhados", "EMI");
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
        List<Produto> prods=new ArrayList<>();
        prods.add(album);
        prods.add(livro);
        prods.add(filme);
        prods.add(livro);
        int id=1;
        prods.stream().filter((produto)->produto.getId()==id).forEach(System.out::println);*/





        Livraria livraria=new Livraria();
        livraria.menuInciar(sc);

    }

    public void menuInciar(Scanner sc) {


        System.out.println("***********************************************************************");
        System.out.println("************   Bem-vindo a Livraria Americanas   **********************");
        System.out.println("***********************************************************************");
        System.out.println("************             Menu Inicial            **********************");
        System.out.println("***********************************************************************");


        System.out.println("****   Digite o número 1 para Acessar o gerenciador de estoque.   *****");
        System.out.println("****   Digite o número 2 para Consultar o estoque de uma categoria. ***");
        System.out.println("****   Digite o número 3 para Consultar o estoque geral.          *****");
        System.out.println("****   Digite o número 4 para Consultar o estoque por categoria.  *****");
        System.out.println("****   Digite o número 5 para realizar uma compra.                *****");
        System.out.println("***********************************************************************");


        //switch case
        String numeroMenuInicial = sc.next();
        switch (numeroMenuInicial) {
            case ("1") -> acessarMenuGerenciadorEstoque(sc);
            case ("2") -> consultarEstoqueCategoria(sc);
            /*case ("3") -> consultarEstoqueGeral();
            case ("4") -> consultaEstoquePorCategoria();
            case ("5") -> realizarCompra();*/
            default ->throw new IllegalStateException("Erro inesperado" + numeroMenuInicial);



        }




    }

    private void consultarEstoqueCategoria(Scanner sc) {
        System.out.println("***************        Listar Produto por categoria         ****************");
        System.out.println("****************************************************************************");
        System.out.println("****   Digite o número 1 para Listar produtos do tipo Album de música. *****");
        System.out.println("****   Digite o número 2 para Listar produtos do tipo Brinquedo.       *****");
        System.out.println("****   Digite o número 3 para Listar produtos do tipo Filme.           *****");
        System.out.println("****   Digite o número 4 para Listar produtos do tipo Jogo.            *****");
        System.out.println("****   Digite o número 5 para Listar produtos do tipo Livro.           *****");
        System.out.println("****   Digite o número 6 para Retornar ao Menu inicial.                *****");
        System.out.println("****************************************************************************");
        String numeroMenuAdicionarProduto = sc.next();
        switch (numeroMenuAdicionarProduto) {
            case ("1") -> listarProdutosCategoria(sc,Categoria.ALBUM);
            case ("2") -> listarProdutosCategoria(sc,Categoria.BRINQUEDO);
            case ("3") -> listarProdutosCategoria(sc,Categoria.FILME);
            case ("4") -> listarProdutosCategoria(sc,Categoria.JOGO);
            case ("5") ->listarProdutosCategoria(sc,Categoria.LIVRO);
            case ("6") -> menuInciar(sc);
            default -> consultarEstoqueCategoria(sc);

    }}

    private void listarProdutosCategoria(Scanner sc, Categoria tipo) {
        if (produtos.stream().anyMatch(produto->produto.getTipo().equals(tipo))){
            produtos.stream().filter(produto->produto.getTipo().equals(tipo)).forEach(System.out::println);
            System.out.println("Existem "+ produtos.stream().filter(produto->produto.getTipo().equals(tipo)).count()+ "Produtos do tipo "+ tipo);
        }else{
            System.out.println("Não há nenhum produto do tipo" + tipo);
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
            case ("2") -> consultarProduto(sc);
            case ("3") -> acessarMenuAlterarProduto(sc);
            case ("4") -> removerProduto(sc);
            case ("5") -> menuInciar(sc);
            default -> acessarMenuGerenciadorEstoque(sc);



        }

    }

    private void removerProduto(Scanner sc) {
        System.out.println("Esta é a lista de produtos em estoque, favor digite o número do Id para ver um produto específico:");
        if (produtos.isEmpty()){
            System.out.println("A lista de produtos esta vazia!");
            acessarMenuGerenciadorEstoque(sc);

        }
        produtos.forEach(System.out::println);
        System.out.println("Digite o número do id do produto que deseja Excluir");
        String produtoId=sc.next();
        int id=Integer.parseInt(produtoId);
        if (produtos.stream().anyMatch(produto -> produto.getId()==id)){
            Produto matchProduct = (Produto) produtos.stream().filter(produto->produto.getId()==id);
            produtos.remove(matchProduct);
            System.out.println("Produto removido com sucesso!");
            acessarMenuGerenciadorEstoque(sc);

        }
        System.out.println("Id não localizado, tecle 1 para tentar novamente ou tecle 2 para retornar ao menu de gerenciamento de estoque");
        String opcaoMenu=sc.next();
        if(opcaoMenu.equals("1")){
            consultarProduto(sc);

        }else{
            acessarMenuGerenciadorEstoque(sc);
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
            case ("6") -> acessarMenuGerenciadorEstoque(sc);
            default -> acessarMenuAdicionarProduto(sc);



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

    private void consultarProduto(Scanner sc) {
        System.out.println("Esta é a lista de produtos em estoque, favor digite o número do Id para ver um produto específico:");
        if (produtos.isEmpty()){
            System.out.println("A lista de produtos esta vazia!");
            acessarMenuGerenciadorEstoque(sc);

        }
        produtos.forEach(System.out::println);
        System.out.println("Digite o número do id do produto desejado");
        String produtoId=sc.next();
        int id=Integer.parseInt(produtoId);
        if (produtos.stream().anyMatch(produto -> produto.getId()==id)){
            produtos.stream().filter(produto->produto.getId()==id).forEach(System.out::println);
            acessarMenuGerenciadorEstoque(sc);


        }
        System.out.println("Id não localizado, tecle 1 para tentar novamente ou tecle 2 para retornar ao menu de gerenciamento de estoque");
        String opcaoMenu=sc.next();
        if(opcaoMenu.equals("1")){
            consultarProduto(sc);

        }else{
            acessarMenuGerenciadorEstoque(sc);
        }


    }

    private void acessarMenuAlterarProduto(Scanner sc) {

        System.out.println("*****************         Alterar Produto         ***************************");
        System.out.println("*****************************************************************************");
        System.out.println("****   Digite o número 1 para Alterar um produto do tipo Album de música. ***");
        System.out.println("****   Digite o número 2 para Alterar um produto do tipo Brinquedo.     *****");
        System.out.println("****   Digite o número 3 para Alterar um produto do tipo Filme.         *****");
        System.out.println("****   Digite o número 4 para Alterar um produto do tipo Jogo.          *****");
        System.out.println("****   Digite o número 5 para Alterar um produto do tipo Livro.         *****");
        System.out.println("****   Digite o número 6 para Retornar ao gerenciador de Estoque. ***********");
        System.out.println("*****************************************************************************");

        String numeroMenuAlterarProduto = sc.next();
        switch (numeroMenuAlterarProduto) {
            case ("1") -> alterarAlbum(sc);
            case ("2") -> alterarBrinquedo(sc);
            case ("3") -> alterarFilme(sc);
            case ("4") -> alterarJogo(sc);
            case ("5") -> alterarLivro(sc);
            case ("6") -> acessarMenuGerenciadorEstoque(sc);
            default -> acessarMenuAlterarProduto(sc);



        }
    }
    private void alterarLivro(Scanner sc) {
        produtos.stream().filter(produto->produto.getTipo().equals(Categoria.LIVRO)).forEach(System.out::println);
        System.out.println();
        System.out.println("Digite o id do produto a ser alterado:");
        String idAlteraProduto=sc.next();
        int id=Integer.parseInt(idAlteraProduto);
        if (produtos.stream().anyMatch(produto -> produto.getId()==id && produto.getTipo().equals(Categoria.LIVRO))){
            Livro livro=(Livro) produtos.stream().filter(produto->produto.getId()==id);
            System.out.println("Digite o nome do Livro:");
            String nome=sc.next();
            livro.setNome(nome);

            System.out.println("Digite o preco do Livro:");
            String precoString=sc.next();
            Double preco=Double.valueOf(precoString);
            livro.setPreco(preco);

            System.out.println("Digite o nome do escritor:");
            String escritor=sc.next();
            livro.setEscritor(escritor);

            System.out.println("Digite o nome do genero:");
            String genero=sc.next();
            livro.addGeneros(genero);

            System.out.println("Digite o nome da editora:");
            String editora=sc.next();
            livro.setEditora(editora);

            System.out.println("Produto alterado com sucesso!");
            System.out.println(livro);
            acessarMenuGerenciadorEstoque(sc);

        }
        System.out.println("Id não localizado, tecle 1 para tentar novamente ou tecle 2 para retornar ao menu de gerenciamento de estoque");
        String opcaoMenu=sc.next();
        if(opcaoMenu.equals("1")){
            alterarBrinquedo(sc);

        }else{
            acessarMenuGerenciadorEstoque(sc);
        }
    }
    private void alterarJogo(Scanner sc) {
        produtos.stream().filter(produto->produto.getTipo().equals(Categoria.JOGO)).forEach(System.out::println);
        System.out.println();
        System.out.println("Digite o id do produto a ser alterado:");
        String idAlteraProduto=sc.next();
        int id=Integer.parseInt(idAlteraProduto);
        if (produtos.stream().anyMatch(produto -> produto.getId()==id && produto.getTipo().equals(Categoria.JOGO))){
            Jogo jogo=(Jogo) produtos.stream().filter(produto->produto.getId()==id);
            System.out.println("Digite o nome do Jogo:");
            String nome=sc.next();
            jogo.setNome(nome);

            System.out.println("Digite o preco do Jogo:");
            String precoString=sc.next();
            Double preco=Double.valueOf(precoString);
            jogo.setPreco(preco);

            System.out.println("Digite o nome do Estudio:");
            String estudio=sc.next();
            jogo.setEstudio(estudio);

            System.out.println("Digite o nome do genero:");
            String genero=sc.next();
            jogo.addGeneros(genero);

            System.out.println("Digite o nome da distribuidora:");
            String distribuidora=sc.next();
            jogo.setDistribuidora(distribuidora);

            System.out.println("Produto alterado com sucesso!");
            System.out.println(jogo);
            acessarMenuGerenciadorEstoque(sc);

        }
        System.out.println("Id não localizado, tecle 1 para tentar novamente ou tecle 2 para retornar ao menu de gerenciamento de estoque");
        String opcaoMenu=sc.next();
        if(opcaoMenu.equals("1")){
            alterarJogo(sc);

        }else{
            acessarMenuGerenciadorEstoque(sc);
        }
    }
    private void alterarFilme(Scanner sc) {
        produtos.stream().filter(produto->produto.getTipo().equals(Categoria.FILME)).forEach(System.out::println);
        System.out.println();
        System.out.println("Digite o id do produto a ser alterado:");
        String idAlteraProduto=sc.next();
        int id=Integer.parseInt(idAlteraProduto);
        if (produtos.stream().anyMatch(produto -> produto.getId()==id&&produto.getTipo().equals(Categoria.FILME))){
            Filme filme=(Filme) produtos.stream().filter(produto->produto.getId()==id);
            System.out.println("Digite o nome do Filme:");
            String nome=sc.next();
            filme.setNome(nome);

            System.out.println("Digite o preco do Filme:");
            String precoString=sc.next();
            Double preco=Double.valueOf(precoString);
            filme.setPreco(preco);

            System.out.println("Digite o nome do genero:");
            String genero=sc.next();
            filme.addGeneros(genero);

            System.out.println("Digite o nome do Produtor:");
            String produtor=sc.next();
            filme.addProdutores(produtor);

            System.out.println("Digite o nome do Selo:");
            String diretor=sc.next();
            filme.addDiretores(diretor);

            System.out.println("Produto alterado com sucesso!");
            System.out.println(filme);
            acessarMenuGerenciadorEstoque(sc);

        }
        System.out.println("Id não localizado, tecle 1 para tentar novamente ou tecle 2 para retornar ao menu de gerenciamento de estoque");
        String opcaoMenu=sc.next();
        if(opcaoMenu.equals("1")){
            alterarFilme(sc);

        }else{
            acessarMenuGerenciadorEstoque(sc);
        }
    }
    private void alterarBrinquedo(Scanner sc) {
        produtos.stream().filter(produto->produto.getTipo().equals(Categoria.BRINQUEDO)).forEach(System.out::println);
        System.out.println();
        System.out.println("Digite o id do produto a ser alterado:");
        String idAlteraProduto=sc.next();
        int id=Integer.parseInt(idAlteraProduto);
        if (produtos.stream().anyMatch(produto -> produto.getId()==id&& produto.getTipo().equals(Categoria.BRINQUEDO))){
            Brinquedo brinquedo=(Brinquedo) produtos.stream().filter(produto->produto.getId()==id);
            System.out.println("Digite o nome do Brinquedo:");
            String nome=sc.next();
            brinquedo.setNome(nome);

            System.out.println("Digite o preco do Brinquedo:");
            String precoString=sc.next();
            Double preco=Double.valueOf(precoString);
            brinquedo.setPreco(preco);

            System.out.println("Digite o Tipo do Brinquedo:");
            String tipoBrinquedo=sc.next();
            brinquedo.setTipoBrinquedo(tipoBrinquedo);


            System.out.println("Produto alterado com sucesso!");
            System.out.println(brinquedo);
            acessarMenuGerenciadorEstoque(sc);

        }
        System.out.println("Id não localizado, tecle 1 para tentar novamente ou tecle 2 para retornar ao menu de gerenciamento de estoque");
        String opcaoMenu=sc.next();
        if(opcaoMenu.equals("1")){
            alterarBrinquedo(sc);

        }else{
            acessarMenuGerenciadorEstoque(sc);
        }

    }
    private void alterarAlbum(Scanner sc) {

        produtos.stream().filter(produto->produto.getTipo().equals(Categoria.ALBUM)).forEach(System.out::println);
        System.out.println();
        System.out.println("Digite o id do produto a ser alterado:");
        String idAlteraProduto=sc.next();
        int id=Integer.parseInt(idAlteraProduto);
        if (produtos.stream().anyMatch(produto -> produto.getId()==id)){
            AlbumMusica album=(AlbumMusica) produtos.stream().filter(produto->produto.getId()==id&& produto.getTipo().equals(Categoria.ALBUM));
            System.out.println("Digite o nome do Albúm:");
            String nome=sc.next();
            album.setNome(nome);

            System.out.println("Digite o preco do Albúm:");
            String precoString=sc.next();
            Double preco=Double.valueOf(precoString);
            album.setPreco(preco);

            System.out.println("Digite o nome do genero:");
            String genero=sc.next();
            album.addGeneros(genero);

            System.out.println("Digite o nome da Banda:");
            String banda=sc.next();
            album.addMusicos(banda);

            System.out.println("Digite o nome do Selo:");
            String selo=sc.next();
            album.addSelos(selo);

            System.out.println("Produto alterado com sucesso!");
            System.out.println(album);
            acessarMenuGerenciadorEstoque(sc);

        }
        System.out.println("Id não localizado, tecle 1 para tentar novamente ou tecle 2 para retornar ao menu de gerenciamento de estoque");
        String opcaoMenu=sc.next();
        if(opcaoMenu.equals("1")){
            alterarAlbum(sc);

        }else{
            acessarMenuGerenciadorEstoque(sc);
        }


    }

}
