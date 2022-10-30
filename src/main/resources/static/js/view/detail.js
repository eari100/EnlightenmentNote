const detail = {
    init: function() {
        const _this = this
        const postSeq = $('#post-seq').val()

        postsApi.findById(postSeq)
            .done(res => _this.renderPost(res))

        $('#edit-btn').click(() => location.href = `/write?mode=edit&postSeq=${postSeq}`)
    },

    renderPost: function(data) {
        const createdDate = dateUtil.makeYmdHmsDateFormat(dateUtil.strToDate(data.createdDate))

        $('#category').append(data.category.name)
        $('#title').append(data.title)
        $('#author').append(data.author)
        $('#created-date').append(createdDate)
        $('#content').append(data.content)
    }
}

detail.init()