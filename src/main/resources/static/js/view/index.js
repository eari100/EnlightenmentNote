const index = {
    init: function() {
        const _this = this

        _this.renderPostsTable('#pagination', 'content', '', '', '', '', 1, 10, _this.makePostsTableHtml)

        categoriesApi.findAll()
            .done(res => $('#category').append(componentUtil.makeCategorySelectBoxHtml(res)))

        $('#search-btn').click(() => {
            _this.search()
        })

        $('#search-div').keydown(function(key) {
            if (key.keyCode == 13) {
                _this.search()
            }
        })

        $('#write-btn').click(() => {
            location.href = '/write?mode=write&postSeq='
        })
    },

    search: function() {
        const _this = this

        const pagination = '#pagination'
        const title = $('#title').val()
        const content = $('#content').val()
        const author = $('#author').val()
        const categorySeq = $('#category').val()

        $(pagination).pagination('destroy')
        _this.renderPostsTable(pagination, 'content', title, content, author, categorySeq, 1, 10, _this.makePostsTableHtml)
    },

    makePostsTableHtml: function(data) {
        let html = ''

        if(data.length === 0) return '데이터가 없습니다.'

        data.forEach(d => {
            const createdDate = dateUtil.makeYmdHmsDateFormat(dateUtil.strToDate(d.createdDate))

            html +=
                `<tr>
                    <td>${d.category.name}</td>
                    <td>
                        <a href="/detail/${d.postSeq}">${d.title}</a>
                    </td>
                    <td>${d.author}</td>
                    <td>${createdDate}</td>
                </tr>`
        })

        return html
    },

    renderPostsTable: function(pagination, locator='content', title, content, author, categorySeq, pageNum=0, pageSize=10, makeHtml) {

        postsApi.findAll(title, content, author, categorySeq,pageNum-1, pageSize)
            .done(res => {
                $(pagination).pagination({
                    dataSource: new Array(res.totalElements), // total 페이지 수를 가지고 오기 위한 트릭
                    pageNumber: pageNum,
                    pageSize: pageSize,
                    className: 'paginationjs-theme-blue',
                    afterInit : function() {
                        $('#tbody').html(makeHtml(res.content))
                    },
                    afterPageOnClick: function(obj, pageNum) {
                        postsApi.findAll(title, content, author,categorySeq,pageNum-1, pageSize)
                            .done(res => {
                                $('#tbody').html(makeHtml(res.content))
                            })
                    },
                    afterPreviousOnClick: function(obj, pageNum) {
                        postsApi.findAll(title, content, author,categorySeq,pageNum-1, pageSize)
                            .done(res => {
                                $('#tbody').html(makeHtml(res.content))
                            })
                    },
                    afterNextOnClick: function(obj, pageNum) {
                        postsApi.findAll(title, content, author,categorySeq,pageNum-1, pageSize)
                            .done(res => {
                                $('#tbody').html(makeHtml(res.content))
                            })
                    }
                })
            })
    }
}

index.init()