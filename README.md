# Ivna Almeida
## Trabalho para a cadeira de: Programação para Dispositivos Móveis I


## Vamos Rachar
**Descrição:** Aplicativo que tem objetivo de dividir o valor de uma conta entre um número de pessoas. Basta inserir o valor da conta no primeiro campo e a quantidade de pessoas no segundo campo que ele calculará o preço por pessoa automaticamente. Você também pode usar o botão de compartilhar para enviar este valor aos seus amigos e também usar o botão de Text to Speech para ouvir o valor final ditado pelo aplicativo.

## Primeira entrega

| Funcionalidades | Pontuação |
| ------ | ------ |
| Por enquanto, o aplicativo só faz divisões do valor pelo número de pessoas | 2 |
| Mas ele já tem um ícone |2 |
| Já permite o compartilhamento do valor final | 2|
| Fala o valor calculado usando TTS | 2 |
| O usuário não precisa clicar para calcular, ele já faz  | 2 |

### Printscreens
1. Tela inicial após inicializar o aplicativo
<img src="https://github.com/ivn4/vamos_rachar/blob/master/screenshots/Screenshot_20220511_210658.png?raw=true" height="800" />
2. Resultado sendo exibido com o campo do valor vazio
<img src="https://github.com/ivn4/vamos_rachar/blob/master/screenshots/Screenshot_20220511_211849.png?raw=true" height="800" />
3. Resultado sendo exibido com o campo de quantidade de pessoas vazio
<img src="https://github.com/ivn4/vamos_rachar/blob/master/screenshots/Screenshot_20220511_211908.png?raw=true" height="800" />
4. Resultado de número inteiro sendo exibido com os dois campos preenchidos
<img src="https://github.com/ivn4/vamos_rachar/blob/master/screenshots/Screenshot_20220511_211920.png?raw=true" height="800" />
5. Resultado de número quebrado sendo exibido com os dois campos preenchidos
<img src="https://github.com/ivn4/vamos_rachar/blob/master/screenshots/Screenshot_20220511_211933.png?raw=true" height="800" />
6. Componente de compartilhamento sendo exibido
<img src="https://github.com/ivn4/vamos_rachar/blob/master/screenshots/Screenshot_20220511_211946.png?raw=true" height="800" />

## Segunda Entrega

| Funcionalidades | Pontuação |
| ------ | ------ |
| Orientação do Dispositivo | 2.5 |
| Para duas classes de Tamanho da Tela do dispositivo | 2.5 |
| Para duas Línguas diferentes (e.g., Inglês e Português)  | 2.5 |
| Acrescente elementos de descrição para tornar o aplicativo acessível | 2.5 |

### Printscreens
1. Emulador Nexus S, tela em inglês e na horizontal.
<img src="https://raw.githubusercontent.com/ivn4/vamos_rachar/master/screenshots/ENnexusShorizontal.png" width="800" />
2. Emulador Nexus S, tela em inglês e na vertical.
<img src="https://raw.githubusercontent.com/ivn4/vamos_rachar/master/screenshots/ENnexusSvertical.png" height="800" />
3. Emulador Nexus S, tela em português e na horizontal.
<img src="https://raw.githubusercontent.com/ivn4/vamos_rachar/master/screenshots/PTnexusShorizontal.png" width="800" />
4. Emulador Nexus S, tela em português e na vertical.
<img src="https://raw.githubusercontent.com/ivn4/vamos_rachar/master/screenshots/PTnexusSvertical.png" height="800" />
5. Emulador Nexus 10, tela em inglês e na horizontal.
<img src="https://raw.githubusercontent.com/ivn4/vamos_rachar/master/screenshots/ENsplitnexus10horizontal.png" width="800" />
6. Emulador Nexus 10, tela em inglês e na vertical.
<img src="https://raw.githubusercontent.com/ivn4/vamos_rachar/master/screenshots/ENsplitnexus10vertical.png" height="800" />
7. Emulador Nexus 10, tela em português e na horizontal.
<img src="https://raw.githubusercontent.com/ivn4/vamos_rachar/master/screenshots/PTtnexus10horizontal.png" width="800" />
8. Emulador Nexus 10, tela em português e na vertical.
<img src="https://raw.githubusercontent.com/ivn4/vamos_rachar/master/screenshots/PTtnexus10vertical.png" height="800" />
9. Teste de acessibilidade, atestando que não há sugestões de melhora.
<img src="https://raw.githubusercontent.com/ivn4/vamos_rachar/master/screenshots/nenhumasugestao.png" height="800" />

## Terceira Entrega

| Funcionalidades | Pontuação |
| ------ | ------ |
| Implementação da Arquitetura Escolhida (MVC) | 10 |

A arquitetura escolhida foi MVC(Model, View, Controller). Existem duas formas conhecidas de se aplicar MVC em se tratando de dispositivos móveis para android:
1. Utilizar as activities e fragments para performar a camada Controller e fazer o update da View.
2. Usar activities ou fracments como View e Controller enquanto o Model será uma classe separada que não extende uma classe do android. 

A forma escolhida foi a segunda.

O arquivo MainActivity.class, que é uma classe que extende AppCompactActivity() está responsável por pegar as informações do model e atualizá-las e, também, exibir, atualizando a View.

O arquivo ContaModel.class é uma classe que não extende classe do android, mas sim funciona como um Observer e tem o papel apenas de ser o Model, ou seja, armazenar os dados relativos a conta.
