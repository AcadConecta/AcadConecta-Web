function carregarConteudo(url) {
    $.ajax({
        url: url,
        method: "GET",
        success: function (response) {
            $("#mainContent").html(response);
        },
        error: function () {
            alert("Error ao gerar conteúdo");
        }
    });
}