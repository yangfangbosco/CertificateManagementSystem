# Certificate Management System
This is a Certificate Management System using Blockchain techniques on Iota, developed by Team YTVTY, during USC Blockchain Hackathon 2019<br><br>
Emails for team members: <br>
yangfang@usc.edu<br>
tongmiao@usc.edu<br>
tramasam@usc.edu<br>
vedashyk@usc.edu<br>
yunliang@usc.edu<br>

# Background
A resume is a very important component for employers to evaluate applicants for a position. It is the first impression for potential employees. However, there are problems where people cheat on their resume by showing fake educational or professional experience. It is hard for recruiters to verify all experience for each candidate. Thus, we would like to create a system that can help with the hiring process using Blockchain technology.

# System Design
The system is implemented in JAVA as well as Javascript. Both versions have the same functionality. In this document, we will focus on the JAVA implementation. The link to python version is : https://github.com/thivyavignesh/iota_achievement_endorsement

There are 2 major parties in the system.
Certificater: Certificaters are verified educational institutions and trustful companies. They are able to verify certificates for students or employees as provements of achievements. For example, educational institutions like USC can verify students degree with our system and the verification will be stored on the chain where no one can modify it. However, certificaters also have the ability to revoke any certificate as well by making a new note on the chain.

Certificatee: Certificatees can receive verification through our system and the verification will be shown on the chain. Thus, certificatees can share their public address with others which will link to all the verification he received.

# Implementation
We implement the following four classes in JAVA:<br>
Certificate: Certificate have its name, issued date, expired date, description.<br>
Certificater: Certificater have its name and public address.<br>
Certificatee: Certificatee have its name and public address.<br>
Utils: THere are helper functions in the class. For example, convert Trytes from and to String.<br>

# Future update
Due to the short amount of time, we only implement the basic feature in the system. However, there are much room for future update:<br>
1. Deduplicate certificate
2. Check the availability before revoke
3. Add the reason of revoking
4. Create a search engine for users to map the certificate with the issuing institution/company
