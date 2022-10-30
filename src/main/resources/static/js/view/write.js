const write = {
    init: function() {
        const _this = this

        $.when(categoriesApi.findAll())
            .done(res => {
                $('#category').append(componentUtil.makeCategorySelectBoxHtml(res))

                const mode = $('#mode').val()
                const postSeq = $('#post-seq').val()
                _this.renderConditionally(mode, postSeq)
            })

        $('#add-template-btn').click(() => {
            const categorySeq = $('#category').val()

            _this.addTemplate(categorySeq)
        })
    },

    renderConditionally: function(mode, postSeq) {
        const _this = this

        if(mode === 'write') {
            $('#mode-description').append('글 등록')
            $('#write-btn').click(() => _this.save())
            $('#write-btn').html('등록')
        } else if(mode === 'edit') {
            $('#mode-description').append('글 수정')
            $('#author').attr('disabled', true)
            $('#write-btn').html('수정')

            postsApi.findById(postSeq)
                .done(res => _this.fillInPostValue(res))

            $('#write-btn').click(() => _this.update(postSeq))
        }
    },

    validate: function() {
        if( !$('#title').val() ) {
            alert('제목을 입력해주세요.')
            $('#title').focus()

            return false
        }

        if( !$('#author').val() ) {
            alert('작성자를 입력해주세요.')
            $('#author').focus()

            return false
        }

        if( !$('#category').val() ) {
            alert('카테고리를 선택해주세요.')
            $('#category').focus()

            return false
        }

        if( !$('#content').val() ) {
            alert('본문을 입력해주세요.')
            $('#content').focus()

            return false
        }

        return true
    },

    save: function() {
        const _this = this

        if( !_this.validate() ) return

        const data = {
            title: $('#title').val(),
            content: $('#content').val(),
            author: $('#author').val(),
            categorySeq: $('#category').val()
        }

        postsApi.save(data)
            .done(() => {
                location.href = '/'
                alert('저장이 완료되었습니다.')})
            .fail(error => alert(`저장 중 오류가 발생했습니다. ${JSON.stringify(error)}`))
    },

    update: function(id) {
        const _this = this

        if( !_this.validate() ) return

        const data = {
            title: $('#title').val(),
            content: $('#content').val(),
            categorySeq: $('#category').val()
        }

        postsApi.update(id, data)
            .done(() => {
                location.href = '/'
                alert('수정이 완료되었습니다.')})
            .fail(error => alert(`저장 중 오류가 발생했습니다. ${JSON.stringify(error)}`))
    },

    fillInPostValue: function(data) {
        $('#category').val(data.category.seq)
        $('#title').val(data.title)
        $('#author').val(data.author)
        $('#content').val(data.content)
    },

    addTemplate: function(categorySeq) {
        const today = dateUtil.makeYmdDayOfWeek(new Date())

        if(categorySeq === '31000000-0000-0000-0000-000000000000') {
            $('#content').append(
`😎 000의 깨점노트 😎
▫오늘의 날짜: ${today}
▫오늘의 날씨: 

1. 오늘 수업의 핵심내용은?
👉🏻

2. 수업 내용 중 가장 와닿았던 것과 그 이유는? 
👉🏻

3. 오늘 수업 중 나에게 적용해야할 한 가지는? 
👉🏻

4. 질문이 있다면?
👉🏻`
            )
        } else if(categorySeq === '32000000-0000-0000-0000-000000000000') {
            $('#content').append(
`[ 000의 묵상노트 ]
▫날짜: ${today}
▫묵상한 성경(장): 마태복음(1장)

1. 오늘 묵상한 성경의 핵심내용
👉🏻

2. 읽으면서 나에게 와닿은 점 혹은 적용할 점
👉🏻

3. 질문이 있다면?
👉🏻`
            )
        }

        const scrollHeight = $('#content').prop('scrollHeight')
        $('#content').scrollTop(scrollHeight)
    }
}

write.init()
