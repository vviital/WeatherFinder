import Ember from 'ember';

export default Ember.Service.extend({

    parseDate(string) {
      string = string.trim();
      let arr = string.split('-');
      return arr;
    },

    checkDate(arr) {
      if (arr.length != 3) {
        return false;
      }
      let bad = arr.some((value) => {
          return isNaN(value) || value === '';
        });
      if (bad) {
        return false;
      }
      let date = new Date(arr[0], arr[1] - 1, arr[2]);
      return (arr[0] == date.getFullYear() && arr[1] == date.getMonth() + 1 && arr[2] == date.getDate()) &&
          (arr[0].length == 4 && arr[1].length == 2 && arr[2].length == 2);
    },

    checkYear(year) {
      return !isNaN(year) && year.length == 4;
    },

    checkMonth(month) {
      return !isNaN(month) && month.length == 2;
    },

    checkDay(day) {
      return !isNaN(day) && day.length == 2;
    }
  });
