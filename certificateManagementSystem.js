///////////////////////////////
// Send HELLOWORLD
///////////////////////////////

const iotaLibrary = require('@iota/core')
const Trytes = require('trytes');

const iota = iotaLibrary.composeAPI({
  provider: 'https://nodes.devnet.thetangle.org:443'
})

const address =
  'HEQLOWORLDHELLOWORLDHELLOWORLDHELLOWORLDHELLOWORLDHELLOWORLDHELLOWORLDHELLOWORYYZ'
const seed =
  'PUEOTSEITFEVEWCWBTSIZM9NKRGJEIMXTULBACGFRQK9IMGICLBKW9TTEVSDQMGWKBXPVCBMMCXWMNPDX'

function verifyInstitute(addr, name){
    var institution = [
        {
          value: 0,
          address: addr,
          message: ''
        }
      ]
      let stringi = Trytes.encodeTextAsTryteString(name + ': ' + address )
      console.log(stringi)
      console.log(Trytes.decodeTextFromTryteString(stringi))
      institution[0].message = stringi
    iota
  .prepareTransfers(seed, institution)
  .then(trytes => iota.sendTrytes(trytes, (depth = 3), (mwm = 9)))
  .then(bundle => {
    console.log(bundle)
  })
  .catch(err => {
    console.error(err)
  })
}

function checkInstitude(addr){

    iota
    .findTransactionObjects({ addresses: [addr] })
    .then(response => {
    //console.log(response)
    console.log(response[0].signatureMessageFragment)
    res_msg = response[0].signatureMessageFragment
    slice_msg = res_msg.slice(0,res_msg.indexOf('99999'))
    console.log(slice_msg)
    console.log(Trytes.decodeTextFromTryteString(slice_msg))
    // console.log(Trytes.decodeTextFromTryteString(response[0].signatureMessageFragment))
    })
    .catch(err => {
    console.error(err)
    })

}

function giveCertificate(addr, certificate){
    var institution = [
        {
          value: 0,
          address: addr,
          message: ''
        }
      ]
      let stringi = Trytes.encodeTextAsTryteString(address + ': ' + certificate + ' granted')
      console.log(stringi)
      console.log(Trytes.decodeTextFromTryteString(stringi))
      institution[0].message = stringi
    iota
  .prepareTransfers(seed, institution)
  .then(trytes => iota.sendTrytes(trytes, (depth = 3), (mwm = 9)))
  .then(bundle => {
    console.log(bundle)
  })
  .catch(err => {
    console.error(err)
  })
}

function revokeCertificate(addr, certificate){
    var institution = [
        {
          value: 0,
          address: addr,
          message: ''
        }
      ]
      let stringi = Trytes.encodeTextAsTryteString(address + ': ' + certificate + ' revoked')
      console.log(stringi)
      console.log(Trytes.decodeTextFromTryteString(stringi))
      institution[0].message = stringi
    iota
  .prepareTransfers(seed, institution)
  .then(trytes => iota.sendTrytes(trytes, (depth = 3), (mwm = 9)))
  .then(bundle => {
    console.log(bundle)
  })
  .catch(err => {
    console.error(err)
  })
}

function checkStudent(addr){

    iota
    .findTransactionObjects({ addresses: [addr] })
    .then(response => {
    //console.log(response)
    var i;
    for (i = 0; i < response.length; i++) { 
        //console.log(response[i].signatureMessageFragment)
        res_msg = response[i].signatureMessageFragment
        slice_msg = res_msg.slice(0,res_msg.indexOf('99999'))
        //console.log(slice_msg)
        console.log(Trytes.decodeTextFromTryteString(slice_msg))
    }
    // console.log(Trytes.decodeTextFromTryteString(response[0].signatureMessageFragment))
    })
    .catch(err => {
    console.error(err)
    })

}

//checkInstitude(address)

//giveCertificate(address, 'certificate_2')

//revokeCertificate(address, 'certificate_2')


checkStudent(address)