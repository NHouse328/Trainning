package com.trainning.vingadores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rcv_vingadores = findViewById(R.id.rcv_vingadores);

        Vingador[] vingadores = new Vingador[]{
                new Vingador(R.mipmap.avenger01, "Gavião Arqueiro", "Gavião Arqueiro (nome original em inglês, Hawkeye) alter-ego de Clint Barton, é um personagem de quadrinhos americanos da Marvel Comics. Criado por Stan Lee e Don Heck, o herói fez sua primeira aparição em Tales of Suspense #57 (Setembro de 1964) antes de se juntar aos Vingadores em Avengers #16 (Maio de 1965). Desde então, Barton tem sido membro proeminente da equipe.\n" +
                        "\n" +
                        "O personagem é interpretado pelo ator Jeremy Renner no Universo Cinematográfico Marvel, um universo fictício compartilhado composto por vários filmes produzidos pela Marvel Studios. A primeira aparição de Renner como Barton foi uma pequena participação em Thor (2011), sendo que o personagem teve uma participação maior em Os Vingadores (2012) e Vingadores: Era de Ultron (2015) e Renner retorna em Capitão América: Guerra Civil (2016)."),

                new Vingador(R.mipmap.avenger02, "Máquina de Combate", "Máquina de Combate (War Machine em inglês) ou como é conhecido também como Patriota de Ferro, é o alter ego de James Rhodes, um super-herói do Universo Marvel que utiliza uma armadura de alta tecnologia construída por Tony Stark."),

                new Vingador(R.mipmap.avenger03, "Thor", "Thor é um personagem fictício que aparece nas histórias em quadrinhos publicadas pela Marvel Comics. Baseado no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee, Larry Lieber e Jack Kirby.\n" +
                        "\n" +
                        "Estreando na Era de Prata dos quadrinhos, o personagem apareceu pela primeira vez em Journey into Mystery #83 (agosto de 1962). Ele é um membro fundador da equipe de heróis dos Vingadores.\n" +
                        "\n" +
                        "Chris Hemsworth interpreta Thor nos filmes do Universo Marvel Cinematográfico: Thor, Os Vingadores, Thor: O Mundo Sombrio, Vingadores: Era de Ultron ; Thor: Ragnarok; Vingadores: Guerra Infinita e Vingadores:Ultimato"),

                new Vingador(R.mipmap.avenger04, "Nick Fury", "Nicholas Joseph Fury ou simplesmente Nick Fury é um personagem fictício que aparece nas histórias em quadrinhos publicadas pela Marvel Comics.\n" +
                        "\n" +
                        "Fury é conhecido por ser o grande líder da agência secreta de espionagem americana da S.H.I.E.L.D."),

                new Vingador(R.mipmap.avenger05, "Loki", "Loki Laufeyson é um personagem fictício e um anti-herói irmão de Thor, e é considerado também um dos principais adversários dos Vingadores. Ele aparece nas histórias em quadrinhos publicadas pela Marvel Comics, ele é baseado no deus Loki da Mitologia Nórdica."),

                new Vingador(R.mipmap.avenger06, "Homem de Ferro", "Homem de Ferro (Iron Man, em inglês) é um personagem fictício dos quadrinhos publicados pela Marvel Comics. Sua identidade verdadeira é a do empresário e bilionário Tony Stark, que usa armaduras de alta tecnologia no combate ao crime. Foi criado em 1963 pelo escritor Stan Lee, o roteirista Larry Lieber, e os desenhistas Jack Kirby e Don Heck. O objetivo de seu criador, Stan Lee, era aceitar o desafio de fazer um personagem ser odiado e depois amado pelo público, assim, criou um dos super heróis mais marcantes de todos os tempos.\n" +
                        "\n" +
                        "A primeira publicação foi em Tales of Suspense #39 (história publicada pela primeira vez no Brasil em Heróis da TV #100). Desde então se tornou um dos personagens mais conhecidos da Marvel, como membro dos Vingadores e adaptações para desenhos animados e cinema (no qual foi interpretado por Robert Downey, Jr.)."),

                new Vingador(R.mipmap.avenger07, "Hulk", "O Hulk, por vezes referido como O Incrível Hulk (The Incredible Hulk, no original em inglês) é um personagem de quadrinhos/banda desenhada do gênero super-herói, propriedade da Marvel Comics, editora pela qual as histórias do personagem são publicados desde sua criação, nos anos 1960. Concebido pelo roteirista Stan Lee (1922-2018) e pelo desenhista Jack Kirby (1917-1994), teve sua primeira aparição junto ao público original dos Estados Unidos na revista The Incredible Hulk n°1, lançada no mercado americano pela Marvel Comics em maio de 1962, um título solo do personagem, garantindo-lhe o acesso ao que mais tarde seria popularmente conhecido como Universo Marvel dos quadrinhos/banda desenhada. A partir de então, o Hulk tem aparecido, protagonizando ou não, diversas histórias da editora, se tornando um dos mais visualmente reconhecíveis da mesma, tendo o universo entorno do personagem se expandido continuadamente ao longo das últimas décadas.\n" +
                        "\n" +
                        "Apesar de fugir de diversos padrões pré-estabelecidos para super-heróis enquanto personagem da cultura pop mundial, Hulk é considerado um super-herói, mais pelas características sobre-humanas por ele apresentadas do que por conceitos bases de inserção no gênero."),

                new Vingador(R.mipmap.avenger08, "Homem Formiga", "Homem-Formiga é o nome de três personagens distintos do Universo Marvel. Todos tem ligações diretas com os Vingadores."),

                new Vingador(R.mipmap.avenger09, "Capitão América", "Capitão América é um super-herói de histórias em quadrinhos americanos publicado pela Marvel Comics. Criado por Joe Simon e Jack Kirby, o primeiro personagem apareceu em Captain America Comics # 1 (março de 1941) da Timely Comics, antecessora da Marvel Comics. Capitão América foi concebido como um super-herói patriótico que lutou contra as potências do Eixo na Segunda Guerra Mundial e foi personagem mais popular da Timely Comics durante o período da guerra. A popularidade dos super-heróis diminuiu após a guerra e os quadrinhos Capitão América foram interrompidos em 1950, com uma volta de curta duração em 1953. Em 1964, o personagem foi reintroduzido como participante do Universo Marvel \n" +
                        "\n" +
                        "Os Capitães Américas vestem trajes inspirados na bandeira dos Estados Unidos e estão armados com um escudo quase indestrutível (feito de uma liga de adamantanium-vibranium, metais fictícios) que atiram em seus inimigos. O Capitão América mais famoso e popular e também o personagem original é o alter-ego de Steve Rogers, um jovem franzino que atinge o pico da perfeição humana após aplicar um soro experimental com o intuito de ajudar os Estados Unidos contra as potências do Eixo. Perto do fim da guerra, ficou preso no gelo e sobreviveu em animação suspensa até que foi revivido nos dias atuais."),

                new Vingador(R.mipmap.avenger10, "Viúva Negra", "Viúva Negra (em inglês Black Widow), (Natalia Alianovna \"Natasha\" Romanova, Russo: Наталья Альяновна \"Наташа\" Романова, também conhecida como Natasha Romanoff) é uma personagem das histórias em quadrinhos do Universo Marvel, publicado pela Marvel Comics.\n" +
                        "\n" +
                        "\n" +
                        "Criada por Stan Lee (edição), Don Rico (roteiro) e Don Heck (desenhos), a personagem apareceu pela primeira vez em Tales of Suspense #52 (abril de 1964). A personagem foi introduzida pela primeira vez como uma espiã russa, antagonista do super-herói Homem de Ferro. Mais tarde, ela fugiu para os Estados Unidos, tornando-se uma agente da S.H.I.E.L.D. e membro da equipe de super-heróis Vingadores.\n" +
                        "\n" +
                        "Scarlett Johansson interpretou a personagem nos filmes de Homem de Ferro 2 (2010), Os Vingadores - The Avengers (2012), Capitão América 2: O Soldado Invernal (2014), Vingadores: Era de Ultron (2015) e Capitão América: Guerra Civil (2016), Avengers: Infinity War (2018) como uma parte da franquia Universo Marvel Cinematográfico."),

                new Vingador(R.mipmap.avenger11, "Agente Coulson", "Phillip \"Phil\" Coulson é um personagem fictício do Universo Cinematográfico Marvel, interpretado por Clark Gregg. Membro de alto escalão da agência de espionagem S.H.I.E.L.D., sua primeira aparição foi no filme Homem de Ferro, de 2008, o primeiro filme no UCM. Gregg retorna em Homem de Ferro 2 (2010), Thor (2011), Os Vingadores (2012) e Capitã Marvel (2019). Ele também protagoniza a série de televisão Agents of S.H.I.E.L.D. (2013-presente), aparece em dois \"Marvel One-Shots\" (2011), tem sido apresentado em várias revistas em quadrinhos tie-ins, e aparece na série digital Agents of S.H.I.E.L.D.: Slingshot (2016).\n" +
                        "\n" +
                        "A popularidade do personagem resultou em sua introdução em outras mídias fora do UCM, incluindo nas revistas em quadrinhos do Universo Marvel publicadas pela Marvel Comics e na série animada Ultimate Spider-Man, onde Coulson contou com a voz e feições de Gregg. Gregg também dublou uma versão Lego de Coulson em Lego Marvel Super Heroes."),

        };

        VingadorAdapter adapter = new VingadorAdapter(MainActivity.this,vingadores);

        rcv_vingadores.setAdapter(adapter);
    }
}
