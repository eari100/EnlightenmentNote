const categoriesApi = {
    findAll: function() {
        return $.ajax({
            type: 'GET',
            url: '/api/v1/categories/list',
            dataType: 'json'
        })
    },
}
