const postsApi = {
    findAll: function(title, content, author, categorySeq, pageNum=0, pageSize=10) {
        return $.ajax({
            type: 'GET',
            url: `/api/v1/posts/list?title=${title}&content=${content}&author=${author}&categorySeq=${categorySeq}&pageNum=${pageNum}&pageSize=${pageSize}`,
            dataType: 'json'
        })
    },

    findById: function(id) {
        return $.ajax({
            type: 'GET',
            url: `/api/v1/posts/${id}`,
            dataType: 'json'
        })
    },

    save: function(data) {
        return $.ajax({
            type: 'POST',
            url: `/api/v1/posts`,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        })
    },

    update: function(id, data) {
        return $.ajax({
            type: 'PATCH',
            url: `/api/v1/posts/${id}`,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        })
    }
}
