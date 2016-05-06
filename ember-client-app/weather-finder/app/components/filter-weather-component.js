import Ember from 'ember';

export default Ember.Component.extend({
    actions: {
        filter() {
            const {year, month, day} = this.getProperties('year', 'month', 'day');
            console.log(year + " " + month + " " + day);
            this.sendAction('onFilter', {year: year, month: month, day: day});
        }
    }
});