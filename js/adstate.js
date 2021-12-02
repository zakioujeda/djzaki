var databaseRef02 = firebase.database().ref('MAIN_ACTIVITY');
var loadgoogleadmob = databaseRef02.child("LoadGoogleAdmob");
var loadfacebook = databaseRef02.child("LoadFacebookAd");


var banner_ad_toggle = document.getElementById("banner_ad_toggle");
var banner_ad_toggle_status = true;

var inters_ad_toggle = document.getElementById("inters_ad_toggle");
var inters_ad_toggle_status = true;

var google_ads_toggle = document.getElementById("google_ads_toggle");
var google_ads_toggle_status = true;


var fbbanner_ad_toggle = document.getElementById("fbbanner_ad_toggle");
var fbbanner_ad_toggle_status = true;

var fbinters_ad_toggle = document.getElementById("fbinters_ad_toggle");
var fbinters_ad_toggle_status = true;

var fb_ads_toggle = document.getElementById("facebook_ads_toggle");
var fb_ads_toggle_status = true;

//Toggle Button State Check
$(fbbanner_ad_toggle).on('change', function() {
  if ($(this).is(':checked')) {
    fbbanner_ad_toggle_status = $(this).is(':checked');
    loadfacebook.child("FacebookAdsState").child("BannerAdState").child("state").set("on");
    loadfacebook.child("FacebookAdsState").child("AllAdState").child("state").set("on");
  }
  else {
    fbbanner_ad_toggle_status = $(this).is(':checked');
    loadfacebook.child("FacebookAdsState").child("BannerAdState").child("state").set("off");
  }
});
//Toggle Button State Check
$(fbinters_ad_toggle).on('change', function() {
  if ($(this).is(':checked')) {
    fbinters_ad_toggle_status = $(this).is(':checked');
    loadfacebook.child("FacebookAdsState").child("IntersAdState").child("state").set("on");
    loadfacebook.child("FacebookAdsState").child("AllAdState").child("state").set("on");
  }
  else {
    fbinters_ad_toggle_status = $(this).is(':checked');
    loadfacebook.child("FacebookAdsState").child("IntersAdState").child("state").set("off");
  }
});
//Toggle Button State Check
$(fb_ads_toggle).on('change', function() {
  if ($(this).is(':checked')) {
    fb_ads_toggle_status = $(this).is(':checked');
    loadfacebook.child("FacebookAdsState").child("BannerAdState").child("state").set("on");
    loadfacebook.child("FacebookAdsState").child("AllAdState").child("state").set("on");
  }
  else {
    fb_ads_toggle_status = $(this).is(':checked');
    loadfacebook.child("FacebookAdsState").child("BannerAdState").child("state").set("off");
    loadfacebook.child("FacebookAdsState").child("IntersAdState").child("state").set("off");
    loadfacebook.child("FacebookAdsState").child("AllAdState").child("state").set("off");
  }
});
//end

//Toggle Button State Check
$(banner_ad_toggle).on('change', function() {
  if ($(this).is(':checked')) {
    banner_ad_toggle_status = $(this).is(':checked');
    loadgoogleadmob.child("AdmobAdsState").child("BannerAdState").child("state").set("on");
    loadgoogleadmob.child("AdmobAdsState").child("AllAdState").child("state").set("on");
  }
  else {
    banner_ad_toggle_status = $(this).is(':checked');
    loadgoogleadmob.child("AdmobAdsState").child("BannerAdState").child("state").set("off");
  }
});

//Toggle Button State Check
$(inters_ad_toggle).on('change', function() {
  if ($(this).is(':checked')) {
    inters_ad_toggle_status = $(this).is(':checked');
    loadgoogleadmob.child("AdmobAdsState").child("IntersAdState").child("state").set("on");
    loadgoogleadmob.child("AdmobAdsState").child("AllAdState").child("state").set("on");
  }
  else {
    inters_ad_toggle_status = $(this).is(':checked');
    loadgoogleadmob.child("AdmobAdsState").child("IntersAdState").child("state").set("off");
  }
});

//Toggle Button State Check
$(google_ads_toggle).on('change', function() {
  if ($(this).is(':checked')) {
    google_ads_toggle_status = $(this).is(':checked');
    loadgoogleadmob.child("AdmobAdsState").child("BannerAdState").child("state").set("on");
    loadgoogleadmob.child("AdmobAdsState").child("AllAdState").child("state").set("on");
  }
  else {
    google_ads_toggle_status = $(this).is(':checked');
    loadgoogleadmob.child("AdmobAdsState").child("BannerAdState").child("state").set("off");
    loadgoogleadmob.child("AdmobAdsState").child("IntersAdState").child("state").set("off");
    loadgoogleadmob.child("AdmobAdsState").child("AllAdState").child("state").set("off");
  }
});

//Google Admob State
  //Admob Banner Ad Check
  loadgoogleadmob.child("AdmobAdsState").child("AllAdState").on('value', function(snapshot) {snapshot.forEach(function(childSnapshot) {
    var childData = childSnapshot.val();
  
    if(childData == "on"){
  
      google_ads_toggle.checked = true;
    } else {
  
      google_ads_toggle.checked = false;
    }
  });
  });
  //Admob Banner Ad Check
  loadgoogleadmob.child("AdmobAdsState").child("BannerAdState").on('value', function(snapshot) {snapshot.forEach(function(childSnapshot) {
    var childData = childSnapshot.val();
  
    if(childData == "on"){
  
      banner_ad_toggle.checked = true;
      google_ads_toggle.checked = true;
  
    } else {
  
      banner_ad_toggle.checked = false;
  
      if (inters_ad_toggle.checked == false){
  
        google_ads_toggle.checked = false;
        loadgoogleadmob.child("AdmobAdsState").child("AllAdState").child("state").set("off");
      }
    }
  });
  });
  
  //Admob Interstitial Ad Check
  loadgoogleadmob.child("AdmobAdsState").child("IntersAdState").on('value', function(snapshot) {snapshot.forEach(function(childSnapshot) {
    var childData = childSnapshot.val();
  
    if(childData == "on"){
  
      inters_ad_toggle.checked = true;
      google_ads_toggle.checked = true;
  
    } else {
  
      inters_ad_toggle.checked = false;
  
      if (banner_ad_toggle.checked == false){
  
        google_ads_toggle.checked = false;
        loadgoogleadmob.child("AdmobAdsState").child("AllAdState").child("state").set("off");
      }
    }
  });
  });

//Form and Submit Button
document.getElementById('load_inters_counter_form').addEventListener('submit', submitLoadIntersCounter);

//Form and Submit Function
function submitLoadIntersCounter(e){
  e.preventDefault();
  // Get values
  var URL = getInputValIntersCounter('load_inters_counter');

  // Send string
  sendIntersCounter(URL);
}

// Function to get get form values
function getInputValIntersCounter(URL){
  return document.getElementById(URL).value;
}

// Send data to firebase
function sendIntersCounter(URL){
  var ref = loadgoogleadmob.child("AdmobAdsState").child("IntersCounter").child("count");

  ref.set(URL);
}

//Set Admob App ID
loadgoogleadmob.child("AdmobAdsState").child("IntersCounter").on('value', function(snapshot) {snapshot.forEach(function(childSnapshot) {
  var appid = childSnapshot.val();

  document.getElementById("load_current_inters_count").innerHTML = appid;
});
});

//Facebook State
//Facebook Banner Ad Check
loadfacebook.child("FacebookAdsState").child("AllAdState").on('value', function(snapshot) {snapshot.forEach(function(childSnapshot) {
  var childData = childSnapshot.val();

  if(childData == "on"){

    fb_ads_toggle.checked = true;
  } else {

    fb_ads_toggle.checked = false;
  }
});
});
//Facebook Banner Ad Check
loadfacebook.child("FacebookAdsState").child("BannerAdState").on('value', function(snapshot) {snapshot.forEach(function(childSnapshot) {
  var childData = childSnapshot.val();

  if(childData == "on"){

    fbbanner_ad_toggle.checked = true;
    fb_ads_toggle.checked = true;

  } else {

    fbbanner_ad_toggle.checked = false;

    if (fbinters_ad_toggle.checked == false){

      fb_ads_toggle.checked = false;
      loadfacebook.child("FacebookAdsState").child("AllAdState").child("state").set("off");
    }
  }
});
});

//Facebook Interstitial Ad Check
loadfacebook.child("FacebookAdsState").child("IntersAdState").on('value', function(snapshot) {snapshot.forEach(function(childSnapshot) {
  var childData = childSnapshot.val();

  if(childData == "on"){

    fbinters_ad_toggle.checked = true;
    fb_ads_toggle.checked = true;

  } else {

    fbinters_ad_toggle.checked = false;

    if (fb_ads_toggle.checked == false){

      fb_ads_toggle.checked = false;
      loadfacebook.child("FacebookAdsState").child("AllAdState").child("state").set("off");
    }
  }
});
});

  //Check Auth State
  firebase.auth().onAuthStateChanged(function(user) {
    if (user) {

      // User is signed in.

      var user = firebase.auth().currentUser;

      if(user != null){
  
        var email_id = user.email;
        document.getElementById("admin_email_id").innerHTML = email_id;
        document.getElementById("admin_email_id2").innerHTML = email_id;
      }

    } else {

      // No user is signed in.
      window.location.assign("login.html")
    }
  });
  
//SignOut Auth
function logout(){
    firebase.auth().signOut();
}