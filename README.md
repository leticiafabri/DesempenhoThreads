# Desempenho-Threads N: M e 1:1
Atividade prática de Performance em Sistemas Ciberfísicos sobre Desempenho entre modelos de threads N:M e 1:1


Tabela comparativa de tempos:

<img width="634" height="162" alt="image" src="https://github.com/user-attachments/assets/87922b8d-ad3a-4268-959c-62ce36645485" />





**Análise de resultados:**

Com base nos tempo de cada modelo de thread, é possível aprender que:

- para poucas threads (100 e 150), o modelo de thread 1:1 tem melhor desempenho. Isso se deve ao fato do overhead (custo extra de gerenciamento de threads) ser baixo, fazendo com que as threads rodem praticamente em paralelo.
- para mais threads (500 e 1000), o modelo de thread N:M é mais vantajoso. Isso se deve ao fato de que com um numero maior de threads para serem gerenciadas, o overhead é muito maior em um modelo 1:1, e no N:M, por conta do pool limitar o número de threads no sistema, evita-se a sobrecarga.

**Conclusões finais:**

- Quando o número de threads de usuário cresce muito, o 1:1 começa a perder desempenho por overhead, e o N:M se mantém eficiente.
