
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
    List<Produto> produtos= new ArrayList<>();
    List<Produto> carrinho= new ArrayList<>();
    Double caixa=1000.0;


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in).useDelimiter("\\n");

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
        System.out.println("****   Digite o número 2 para Consultar o estoque por categoria.  *****");
        System.out.println("****   Digite o número 3 para Consultar o estoque geral.          *****");
        System.out.println("****   Digite o número 4 para realizar uma compra.                *****");
        System.out.println("***********************************************************************");


        //switch case
        String numeroMenuInicial = sc.next();
        switch (numeroMenuInicial) {
            case ("1") -> acessarMenuGerenciadorEstoque(sc);
            case ("2") -> consultarEstoqueCategoria(sc);
            case ("3") -> consultarEstoqueGeral(sc);
            case ("4") -> acessarMenuCompra(sc);
            default -> menuInciar(sc);

        }

    }

    private void acessarMenuCompra(Scanner sc) {
        System.out.println();
        System.out.println("Essa é a lista atual de produtos em estoque: ");

        produtos.forEach(System.out::println);
        System.out.println();

        System.out.println("Seu carrinho de compras atual tem "+ carrinho.size() + " itens");
        System.out.println();
        System.out.println("Carrinho de compras: ");
        carrinho.forEach(System.out::println);
        double valorTotal= carrinho.stream().mapToDouble(Produto::getPreco).sum();
        System.out.println("Valor total da compra: " + valorTotal);
        System.out.println();
        System.out.println("Digite 1 para adicionar os itens na sua sacola, 2 para remover, 3 para finalizar a compra ou 4 retornar ao menu inicial.");
        String opcaoMenuCompra=sc.next();
        switch (opcaoMenuCompra) {
            case ("1") -> incluirProdutosCarrinho(sc);
            case ("2") -> removerProdutosCarrinho(sc);
            case ("3") -> finalizarCompra(sc);
            default -> menuInciar(sc);

        }

    }

    private void finalizarCompra(Scanner sc) {
        //remover produtos do estoque
        if(carrinho.size()==0){
            System.out.println("Seu carrinho esta vazio, portanto, não será possível encerrar a compra");
            System.out.println("Retorne para o menu de compras.");
            acessarMenuCompra(sc);
        }
        List<Integer> idCompras=carrinho.stream().map(Produto::getId).toList();
        produtos.removeIf(produto->idCompras.stream().toList().contains(produto.getId()));
        double valorTotal= carrinho.stream().mapToDouble(Produto::getPreco).sum();
        this.caixa+=valorTotal;
        System.out.println("Sua compra totalizou " + valorTotal);
        System.out.println();
        System.out.println("Lista dos itens adquiridos: ");
        carrinho.forEach(System.out::println);
        System.out.println("Agradecemos a preferência e volte sempre!");
        System.out.println("Após a venda, o caixa total da Livraria é de " + "R$ " + this.caixa);
        carrinho.clear();
        menuInciar(sc);

    }

    private void removerProdutosCarrinho(Scanner sc) {
        System.out.println("Escolha o item que irá ser removido do seu carrinho de compras através do número do id");
        if (carrinho.isEmpty()){
            System.out.println("Seu carrinho esta vazio, portanto não é possível excluir produtos!");
            acessarMenuCompra(sc);

        }
        String produtoId=sc.next();
        int id=Integer.parseInt(produtoId);
        if (carrinho.stream().anyMatch(produto -> produto.getId()==id)){
            carrinho.removeIf(produto-> produto.getId()==id);
            System.out.println("Produto removido com sucesso!");
            acessarMenuCompra(sc);

        }
        System.out.println("Id não localizado, tecle 1 para tentar novamente ou tecle 2 para retornar ao menu de Compras");
        String opcaoMenu=sc.next();
        if(opcaoMenu.equals("1")){
            removerProdutosCarrinho(sc);

        }else{
            acessarMenuCompra(sc);
        }
    }

    private void incluirProdutosCarrinho(Scanner sc) {
        System.out.println("Escolha os items que irão compor seu carrinho de compras através do número do id");
        String idProduto=sc.next();
        int id= Integer.parseInt(idProduto);
        if (produtos.stream().anyMatch(produto -> produto.getId()==id)){
            Optional<Produto> matchProduct = produtos.stream().filter(produto->produto.getId()==id).findFirst();
            if (matchProduct.isPresent()){
                Produto produto=matchProduct.get();
                carrinho.add(produto);
                System.out.println("Item adicionado ao carrinho");

            }
        }else{
            System.out.println("Produto não encontrado no estoque. Tente novamente!");

        }
        acessarMenuCompra(sc);

    }

    private void consultarEstoqueGeral(Scanner sc) {
        produtos.forEach(System.out::println);
        System.out.println("Tecle 1 para consultar o estoque novamente ou tecle 2 para retornar ao menu inicial");
        String opcaoMenu=sc.next();
        if(opcaoMenu.equals("1")){
            consultarProduto(sc);

        }else{
            menuInciar(sc);
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
            case ("5") -> listarProdutosCategoria(sc,Categoria.LIVRO);
            case ("6") -> menuInciar(sc);
            default -> consultarEstoqueCategoria(sc);

    }}

    private void listarProdutosCategoria(Scanner sc, Categoria tipo) {
        if (produtos.stream().anyMatch(produto->produto.getTipo().equals(tipo))){
            produtos.stream().filter(produto->produto.getTipo().equals(tipo)).forEach(System.out::println);
            System.out.println("Existem "+ produtos.stream().filter(produto->produto.getTipo().equals(tipo)).count()+ " Produtos do tipo "+ tipo);
        }else{
            System.out.println("Não há nenhum produto do tipo " + tipo);


        }
        consultarEstoqueCategoria(sc);
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
            produtos.removeIf(produto->produto.getId()==id);

            System.out.println("Produto removido com sucesso!");
            acessarMenuGerenciadorEstoque(sc);

        }
        System.out.println("Id não localizado, tecle 1 para tentar novamente ou tecle 2 para retornar ao menu de gerenciamento de estoque");
        String opcaoMenu=sc.next();
        if(opcaoMenu.equals("1")){
            removerProduto(sc);

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
        System.out.println("Produto adicionado com sucesso!");
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
        System.out.println("Produto adicionado com sucesso!");
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

        System.out.println("Digite o nome do Produtor do Filme:");
        String produtor=sc.next();

        System.out.println("Digite o nome do Estudio:");
        String estudio=sc.next();

        Filme filme=new Filme(nome,preco,diretor,genero,estudio,produtor);
        produtos.add(filme);
        System.out.println("Produto adicionado com sucesso!");
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
        System.out.println("Produto adicionado com sucesso!");
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
        System.out.println("Produto adicionado com sucesso!");
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
            Optional<Produto> matchLivro=produtos.stream().filter(produto->produto.getId()==id).findFirst();
            if(matchLivro.isPresent()){
                Livro livro=(Livro) matchLivro.get();
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

            }

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
            Optional<Produto> matchJogo=produtos.stream().filter(produto->produto.getId()==id).findFirst();
            if (matchJogo.isPresent()){
                Jogo jogo=(Jogo) matchJogo.get();
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
            }

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
            Optional<Produto> matchFilme=produtos.stream().filter(produto->produto.getId()==id).findFirst();
            if (matchFilme.isPresent()){
                Filme filme=(Filme) matchFilme.get();
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

                System.out.println("Digite o nome do Diretor:");
                String diretor=sc.next();
                filme.addDiretores(diretor);

                System.out.println("Digite o nome do estudio do Filme:");
                String estudio=sc.next();
                filme.setEstudio(estudio);


                System.out.println("Produto alterado com sucesso!");
                System.out.println(filme);

            }

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
            Optional<Produto> matchBrinquedo=produtos.stream().filter(produto->produto.getId()==id).findFirst();
            if(matchBrinquedo.isPresent()){
                Brinquedo brinquedo= (Brinquedo) matchBrinquedo.get();
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

            }

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
        if (produtos.stream().anyMatch(produto -> produto.getId()==id && produto.getTipo().equals(Categoria.ALBUM))){
            Optional<Produto>  matchAlbum = produtos.stream().filter(produto->produto.getId()==id).findFirst();
            if (matchAlbum.isPresent()){
                AlbumMusica album=(AlbumMusica) matchAlbum.get();
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
            }

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
