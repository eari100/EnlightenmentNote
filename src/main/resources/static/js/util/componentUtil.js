const componentUtil = {
    makeCategorySelectBoxHtml: function(data) {
        let html = ''

        data.forEach(d => {
            html += `<option value="${d.seq}">${d.name}</option>`
        })

        return html
    }
}