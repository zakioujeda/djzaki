var databaseRef02 = firebase.database().ref('MAIN_ACTIVITY');
var loadgoogleadmob = databaseRef02.child("LoadGoogleAdmob");
var loadfacebook = databaseRef02.child("LoadFacebookAd");




document.getElementById('load_facebook_banner_id_form').addEventListener('submit', submitFBLoadBannerID);

//Form and Submit Function
function submitFBLoadBannerID(e){
  e.preventDefault();
  // Get values
  var URL = getFBInputValBannerID('load_facebook_banner_id');

  // Send string
  sendFBBannerId(URL);
}

// Function to get get form values
function getFBInputValBannerID(URL){
  return document.getElementById(URL).value;
}

// Send data to firebase
function sendFBBannerId(URL){
  var ref = loadfacebook .child("FacebookBannerId").child("id");

  ref.set(URL);
}

//Set Admob App ID
loadfacebook.child("FacebookBannerId").on('value', function(snapshot) {snapshot.forEach(function(childSnapshot) {
  var appid = childSnapshot.val();

  document.getElementById("load_current_facebook_banner_id").innerHTML = appid;
});
});
//end
//start
document.getElementById('load_facebook_inters_id_form').addEventListener('submit', submitFBLoadIntersID);
//Form and Submit Function
function submitFBLoadIntersID(e){
  e.preventDefault();
  // Get values
  var URL = getFBInputValIntersID('load_facebook_inters_id');

  // Send string
  sendFBIntersId(URL);
}

// Function to get get form values
function getFBInputValIntersID(URL){
  return document.getElementById(URL).value;
}

// Send data to firebase
function sendFBIntersId(URL){
  var ref = loadfacebook .child("FacebookIntersId").child("id");

  ref.set(URL);
}

//Set Admob App ID
loadfacebook.child("FacebookIntersId").on('value', function(snapshot) {snapshot.forEach(function(childSnapshot) {
  var appid = childSnapshot.val();

  document.getElementById("load_current_facebook_inters_id").innerHTML = appid;
});
});
//end














 // ------------- GOOGLE ADMOB ADS MENU ------------- //
//Google Admob Settings

// ------------- APP ID ------------- //
//Form and Submit Button
document.getElementById('load_admob_app_id_form').addEventListener('submit', submitLoadAppID);

//Form and Submit Function
function submitLoadAppID(e){
  e.preventDefault();
  // Get values
  var URL = getInputValAppID('load_admob_app_id');

  // Send string
  sendAppId(URL);
}

// Function to get get form values
function getInputValAppID(URL){
  return document.getElementById(URL).value;
}

// Send data to firebase
function sendAppId(URL){
  var ref = loadgoogleadmob .child("AdmobAppId").child("id");

  ref.set(URL);
}

//Set Admob App ID
loadgoogleadmob.child("AdmobAppId").on('value', function(snapshot) {snapshot.forEach(function(childSnapshot) {
  var appid = childSnapshot.val();

  document.getElementById("load_current_admob_app_id").innerHTML = appid;
});
});

// ------------- BANNER ID ------------- //
//Form and Submit Button
document.getElementById('load_admob_banner_id_form').addEventListener('submit', submitLoadBannerID);

//Form and Submit Function
function submitLoadBannerID(e){
  e.preventDefault();
  // Get values
  var URL = getInputValBannerID('load_admob_banner_id');

  // Send string
  sendBannerId(URL);
}

// Function to get get form values
function getInputValBannerID(URL){
  return document.getElementById(URL).value;
}

// Send data to firebase
function sendBannerId(URL){
  var ref = loadgoogleadmob .child("AdmobBannerId").child("id");

  ref.set(URL);
}

//Set Admob App ID
loadgoogleadmob.child("AdmobBannerId").on('value', function(snapshot) {snapshot.forEach(function(childSnapshot) {
  var appid = childSnapshot.val();

  document.getElementById("load_current_admob_banner_id").innerHTML = appid;
});
});

// ------------- INTERSTITIAL ID ------------- //
//Form and Submit Button
document.getElementById('load_admob_inters_id_form').addEventListener('submit', submitLoadIntersID);

//Form and Submit Function
function submitLoadIntersID(e){
  e.preventDefault();
  // Get values
  var URL = getInputValIntersID('load_admob_inters_id');

  // Send string
  sendIntersId(URL);
}

// Function to get get form values
function getInputValIntersID(URL){
  return document.getElementById(URL).value;
}

// Send data to firebase
function sendIntersId(URL){
  var ref = loadgoogleadmob .child("AdmobIntersId").child("id");

  ref.set(URL);
}

//Set Admob App ID
loadgoogleadmob.child("AdmobIntersId").on('value', function(snapshot) {snapshot.forEach(function(childSnapshot) {
  var appid = childSnapshot.val();

  document.getElementById("load_current_admob_inters_id").innerHTML = appid;
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