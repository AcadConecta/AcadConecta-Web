function loadMessages(chanelNumber) {
    $(document).ready(function() {
            $.ajax({
                url: '/showAllByChannel/' + chanelNumber, // URL para o método do controlador
                type: 'GET',
                dataType: 'text',
                success: function(data) {
                    $('#chat-show').empty(); // Limpa a lista antes de adicionar novos itens
                    $('#chat-show').append('<div>' + data + '</div>');
                },
                error: function(error) {
                    console.error('Erro ao carregar usuários:', error);
                }
            });
    });
}