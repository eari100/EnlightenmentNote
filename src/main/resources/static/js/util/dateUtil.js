const dateUtil = {
    strToDate: function(str) {
        return new Date(str)
    },

    makeYmdDateFormat: function(date) {
        const _this = this

        return `${date.getFullYear()}-${_this.makeTwoDigits(date.getMonth()+1)}-${_this.makeTwoDigits(date.getDate())}`
    },

    makeHmsDateFormat: function(date) {
        const _this = this

        return `${_this.makeTwoDigits(date.getHours())}:${_this.makeTwoDigits(date.getMinutes())}:${_this.makeTwoDigits(date.getSeconds())}`
    },

    makeYmdHmsDateFormat: function(date) {
        const _this = this

        return `${_this.makeYmdDateFormat(date)} ${_this.makeHmsDateFormat(date)}`
    },

    makeTwoDigits: function(x) {
        return `0${x}`.slice(-2)
    },

    makeYmdDayOfWeek: function(date) {
        const _this = this
        const year = date.getFullYear().toString().substring(2,4)

        return `${year}.${_this.makeTwoDigits(date.getMonth()+1)}.${_this.makeTwoDigits(date.getDate())} (${_this.getDayOfWeek(date)})`
    },

    getDayOfWeek: function(date) {
        const week = ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일']
        const dayOfWeek = week[date.getDay()]

        return dayOfWeek
    }
}