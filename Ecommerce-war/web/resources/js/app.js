/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$('.button-collapse').sideNav({
      menuWidth: 300, // Default is 300
      edge: 'left', // Choose the horizontal origin
      closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
      draggable: true // Choose whether you can drag to open on touch screens
    }
  );

$('.datepicker').pickadate({
  selectMonths: true,
  selectYears: 40,
  min: new Date(1960, 0, 1),
  max: new Date(),
  closeOnSelect: true,
  closeOnClear: true,
  format: 'dd-mmm-yyyy'
});

$('#birthDate').click(function(event){
  event.stopPropagation();
  $(".datepicker").first().pickadate("picker").open();
})

