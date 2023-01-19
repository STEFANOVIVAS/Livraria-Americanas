package Twitter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

class Tweet {
    Usuario usuario;
    LocalDateTime hora;
    String frase;


    public Tweet(Usuario usuario, String frase){
        this.usuario=usuario;
        this.hora=LocalDateTime.now();
        this.frase=frase;

    }
    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return hora.format(format)+"-"+frase+"-"+ usuario.getNome();

    }

}




class Usuario {

    String nome;
    String senha;

    Tweet[] tweets=new Tweet[30];



    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    Tweet[] tweet;

    public Usuario(String nome,String senha){
        this.nome=nome;
        this.senha=senha;

    }

    public void tweet(Tweet tweet){
        int numeroTweets=contarTweets();
        tweets[numeroTweets]=tweet;
        System.out.println(tweet);

    }

    public int contarTweets(){
        int count=0;
        for(int i=0;i<tweets.length;i++){
            if(tweets[i]!=null){
                count++;
            }

        }
        return count;
    }

    public void imprimeTweets(){

        int numeroTweets=contarTweets();
        if(numeroTweets>0){
            for(int i=numeroTweets-1;i>=0;i--){
                System.out.println(tweets[i]);
            }

        }else{
            System.out.println("Você ainda não publicou nenhum Tweet!");
        }

    }


}




public class Twitter {
    Usuario[] usuarios = new Usuario[50];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");
        Twitter twitter = new Twitter();
        twitter.menuInciar(sc);
        System.out.println(Arrays.toString(twitter.usuarios));


    }

    public void menuInciar(Scanner sc) {


        System.out.println("*************************************************************");
        System.out.println("************     Bem-vindo ao twitter da Ada     ************");
        System.out.println("*************************************************************");
        System.out.println("*************************************************************");
        System.out.println("************             Menu Inicial            ************");
        System.out.println("*************************************************************");


        System.out.println("**   1. Digite o número 1 para logar!                      **");
        System.out.println("**   2. Digite o número 2 para se cadastrar!               **");
        System.out.println("**   3. Digite o número 3 se deseja sair do aplicativo     **");
        System.out.println("*************************************************************");


        //switch case
        String numeroMenuInicial = sc.next();
        if (numeroMenuInicial.equals("1")) {
            this.menuLogar(sc);
        } else if (numeroMenuInicial.equals("2")){
            this.menuCadastrar(sc);

        }System.exit(1);


    }

    public void menuCadastrar(Scanner sc) {
        System.out.println("*************************************************************");
        System.out.println("****************           Cadastrar           **************");
        System.out.println("*************************************************************");

        String nome;
        String senha;
        String confirmaSenha;
        boolean usuarioExistente = false;
        int usuariosCadastrados = this.usuariosCadastrados();




        do {
            usuarioExistente = false;
            System.out.println("Digite seu usuario:                                         ");
            nome = sc.next();
            //Verificando se o cadastro de usuários esta vazio, em caso negativo,
            // procurar se já existe um usuário com mesmo nome.

            //Diminuir codigo funções

            for (Usuario usuario : this.usuarios) {
                if (usuario == null) {
                    break;

                }
                if (usuario.nome.equals(nome)) {
                    usuarioExistente = true;
                    System.out.println("Já existe um usuário com o mesmo nome");
                    break;
                }
            }




        } while (usuarioExistente);
        do {
            System.out.println("Digite sua senha:                                           ");
            senha = sc.next();
            System.out.println("Confirme sua senha:                                         ");
            confirmaSenha = sc.next();

        } while (!senha.equals(confirmaSenha));

        System.out.println("Usuário criado com sucesso");

        Usuario user = new Usuario(nome, senha);
        usuarios[usuariosCadastrados] = user;
        this.menuInciar(sc);

    }

    public void menuLogar(Scanner sc) {
        System.out.println("*************************************************************");
        System.out.println("****************             Logar             **************");
        System.out.println("*************************************************************");

        int usuariosCadastrados = this.usuariosCadastrados();
        boolean usuarioExiste = false;
        boolean senhaConfere = false;
        do {
            usuarioExiste = false;
            System.out.println("Digite seu usuario:");
            String nome = sc.next();
            System.out.println("Digite sua senha:");
            String senha = sc.next();
            for (int i = 0; i < usuariosCadastrados; i++) {
                if (this.usuarios[i].getNome().equals(nome) && this.usuarios[i].getSenha().equals(senha)) {
                    usuarioExiste = true;
                    System.out.println("Usuário logado com sucesso");
                    this.menuTimeline(this.usuarios[i], sc);
                }

            }
            System.out.println("Usuário inexistente ou dados informados incorretos");
            System.out.println("Digite 1 para tentar novamente ou digite 2 para ir para o cadastramento de usuários");
            int menu = sc.nextInt();
            if (menu == 2) {
                this.menuCadastrar(sc);
            }

        } while (!senhaConfere && !usuarioExiste);


    }

    public void menuTimeline(Usuario usuario, Scanner sc) {
        System.out.println("*************************************************************");
        System.out.println("****  " + usuario.getNome() + " Bem-vindo à sua Timeline!  ****");
        System.out.println("*************************************************************");
        System.out.println("**   1. Digite o número 1 para twittar!                    **");
        System.out.println("**   2. Digite o número 2 para listar usuarios!            **");
        System.out.println("**   3. Digite o número 3 para voltar ao menu principal    **");
        System.out.println("*************************************************************");


        usuario.imprimeTweets();

        System.out.println("Digite uma opção:");

        String menu = sc.next();

        if (menu.equals("1")) {
            this.menuTwittar(usuario, sc);
        } else if (menu.equals("2")) {
            this.listaUsuarios(usuario, sc);
        } else if (menu.equals("3")) {
            this.menuInciar(sc);
        } else this.menuTimeline(usuario, sc);


    }

    public int usuariosCadastrados() {
        int count = 0;
        for (int i = 0; i < this.usuarios.length; i++) {
            if (this.usuarios[i] != null) {
                count++;

            }

        }
        return count;
    }

    public void listaUsuarios(Usuario usuario, Scanner sc) {
        int usuarios = usuariosCadastrados();
        System.out.println("Lista de usuários:");
        for (int i = 0; i < usuarios; i++) {
            System.out.println(this.usuarios[i].getNome());
        }
        System.out.println("Digite 1 para voltar a timeline ou 2 para voltar ao menu inicial");
        String menu = sc.next();
        if (menu.equals("1")) {
            this.menuTimeline(usuario, sc);

        } else if (menu.equals("2")) {
            this.menuInciar(sc);
        }
        this.listaUsuarios(usuario, sc);
    }

    public void menuTwittar(Usuario usuario, Scanner sc) {

        System.out.println("Digite o que esta pensando neste momento:");
        String frase = sc.next();


        Tweet tweet = new Tweet(usuario, frase);
        System.out.println("Tweet adicionado");
        usuario.tweet(tweet);

        this.menuTimeline(usuario, sc);


    }
}
