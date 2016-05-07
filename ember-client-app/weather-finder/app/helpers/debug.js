import Ember from 'ember';

export function debug(params/*, hash*/) {
  console.log(params);
  return params;
}

export default Ember.Helper.helper(debug);
