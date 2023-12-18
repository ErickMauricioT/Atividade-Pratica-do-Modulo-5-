// Dados das viagens
const dadosViagens = [
    { destino: "Pernambuco", preco: "100.00" },
    { destino: "Recife", preco: "120.00" },
    { destino: "Praia do Forte", preco: "120.00" },
    { destino: "Bahia", preco: "120.00" }
    // Adicione mais objetos com os dados das viagens
];

// Função para preencher a tabela com os dados das viagens
function popularTabelaViagens(dados) {
    const tabelaViagens = document.getElementById('tabelaViagens');
    tabelaViagens.innerHTML = ''; // Limpar tabela

    dados.forEach((viagem) => {
        const row = tabelaViagens.insertRow();
        const cellDestino = row.insertCell(0);
        const cellPreco = row.insertCell(1);

        cellDestino.innerHTML = viagem.destino;
        cellPreco.innerHTML = viagem.preco;
    });
}

// Função para buscar destinos
function buscar() {
    const termoBusca = document.getElementById('inputBusca').value.toLowerCase();
    const resultados = dadosViagens.filter((viagem) =>
        viagem.destino.toLowerCase().includes(termoBusca)
    );

    popularTabelaViagens(resultados);
}

// Ao carregar a página, preencher a tabela com todos os dados iniciais
window.onload = function() {
    popularTabelaViagens(dadosViagens);
};
