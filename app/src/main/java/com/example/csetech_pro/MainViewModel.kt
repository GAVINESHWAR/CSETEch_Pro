package com.example.csetech_pro

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _courses = MutableStateFlow(allCourses)

    private val _internships = MutableStateFlow(allinternships)



    @OptIn(FlowPreview::class)
    fun filterCoursesWithContext(context: Context) = searchText
        .debounce(1000L)
        .onEach { _isSearching.update { true } }
        .combine(_courses) { text, courses ->
            if (text.isBlank()) {
                courses
            } else {
                courses.filter {
                    it.doesMatchSearchQuery(text, context)
                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _courses.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }


    @OptIn(FlowPreview::class)
    fun filterInternshipsWithContext() = searchText
        .debounce(1000L)
        .onEach { _isSearching.update { true } }
        .combine(_internships) { text, internships ->
            if (text.isBlank()) {
                internships
            } else {
                internships.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _internships.value
        )
}

data class Course(
    @DrawableRes val courseImage: Int,
    @StringRes val courseName: Int,
    @StringRes val courseDes: Int,
    @StringRes val courseLink: Int
) {
    fun doesMatchSearchQuery(query: String, context: Context): Boolean {
        val courseNameStr = context.getString(courseName)
        val matchingCombinations = listOf(
            courseNameStr,
            "${courseNameStr.first()}",
            courseNameStr.lowercase(),
            courseNameStr.uppercase(),
            courseNameStr.take(3),
            courseNameStr.takeLast(3)
        )
        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

data class Platforms(
    val Title:String,
    val image:String,
    val dec:String,
    val link:String
){
    fun doesMatchSearchQuery(text: String): Boolean {
        val combinations = listOf(
            Title,
            "${Title.first()}",
            Title.lowercase(),
            Title.uppercase(),
            Title.take(3)
        )
        return combinations.any{
            it.contains(text,ignoreCase = true)
        }
    }

}

private val allCourses=listOf(
    Course(R.drawable.android,R.string.c1,R.string.d1,R.string.l1 ),
    Course(R.drawable.ai,R.string.c2,R.string.d2,R.string.l2 ),
    Course(R.drawable.cs,R.string.c3,R.string.d3,R.string.l3 ),
    Course(R.drawable.ds,R.string.c4,R.string.d4,R.string.l4 ),
    Course(R.drawable.devops,R.string.c5,R.string.d7,R.string.l7 ),
    Course(R.drawable.uiux,R.string.c8,R.string.d5,R.string.l5 ),
    Course(R.drawable.gd,R.string.c6,R.string.d6,R.string.l6 ),
    Course(R.drawable.ml,R.string.c7,R.string.d8,R.string.l8 ),
    Course(R.drawable.wd,R.string.c9,R.string.d9,R.string.l9 ),
    Course(R.drawable.w3,R.string.c10,R.string.d10,R.string.l10),
    Course(R.drawable.ca,R.string.c11,R.string.d11,R.string.l11),
    Course(R.drawable.cn,R.string.c12,R.string.d12,R.string.l12),
    Course(R.drawable.os,R.string.c13,R.string.d13,R.string.l13),
    Course(R.drawable.li,R.string.c14,R.string.d14,R.string.l14),
    Course(R.drawable.dsa,R.string.c15,R.string.d15,R.string.l15),
    Course(R.drawable.mdb,R.string.c16,R.string.d16,R.string.l16),
    Course(R.drawable.msql,R.string.c17,R.string.d17,R.string.l17),
    Course(R.drawable.nsql,R.string.c18,R.string.d18,R.string.l18),
    Course(R.drawable.w3,R.string.c19,R.string.d19,R.string.l19),
    Course(R.drawable.w3,R.string.c20,R.string.d20,R.string.l20),
    Course(R.drawable.kp,R.string.c21,R.string.d21,R.string.l21),
    Course(R.drawable.cpp,R.string.c22,R.string.d22,R.string.l22),
    Course(R.drawable.cp,R.string.c23,R.string.d23,R.string.l23),
    Course(R.drawable.jp,R.string.c24,R.string.d24,R.string.l24),
    Course(R.drawable.pp,R.string.c25,R.string.d25,R.string.l25),
)

private val allinternships=listOf(
    Platforms(Title = "Internshala",
        image = "https://sightsinplus.com/wp-content/uploads/2022/08/Internshala-launches-Internship-with-Dream-Companies.jpg",
        dec = "Internshala is an online platform that connects students and recent graduates with internships, online training, and job opportunities. It serves as a comprehensive portal offering a wide range of resources aimed at enhancing the professional and educational growth of young individuals.",
        link = "https://internshala.com/"),
    Platforms(Title = "LinkedIn",
        image = "https://media.licdn.com/dms/image/C5612AQHvzL-_J1rRWg/article-cover_image-shrink_600_2000/0/1614895141102?e=2147483647&v=beta&t=61j64lYBEW2Lu2J0FC6oqxfHhlPcXdgRtB--3klMdqE",
        dec =  "This platform connects students with leading companies and startups across India, providing internships in areas like engineering, design, marketing, management, and more. \n" +
                "\n" +
                "The platform also offers resources like career advice, interview tips, and resume-building guidance to help students prepare for their internship experience. ",
        link = "https://in.linkedin.com/"),
    Platforms(Title = "Indeed",
        image = "https://d34k7i5akwhqbd.cloudfront.net/allspark/static/images/indeed-share-image-9581a8.png" ,
        dec ="Indeed provides a user-friendly interface that makes it easy for students to search and apply for internships. The platform also offers resources like career advice, interview tips, and resume-building guidance to help students prepare for their internship experience. " ,
        link = "https://in.indeed.com/"),
    Platforms(Title = " LetsIntern",
        image = "https://admin.headsupcorporation.com/wp-content/uploads/2019/12/Untitled-1.jpg",
        dec =  "This platform is known for its user-friendly interface and offers internships in areas like engineering, management, media, design, law, and more. LetsIntern has partnerships with over 30,000 companies and has helped thousands of students secure internships in their desired fields. ",
        link = "https://letsintern.in/"),
    Platforms(Title = "Hello Intern",
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ97I9nXhfQqUBff-tLMgVAHyFQcuC1HnUHBw&s" ,
        dec = "This platform connects students with leading companies and startups across India, providing internships in areas like marketing, sales, design, engineering, and more. Hello, Intern also offers remote internship opportunities for students who are unable to travel or relocate for their internships. ",
        link = "https://hellointern.in/"),
    Platforms(Title = " Twenty19",
        image = "https://image4.owler.com/logo/twenty19_owler_20180528_061331_original.png",
        dec ="This platform connects students with over 10,000 companies and startups across India, providing internships in areas like engineering, management, design, marketing, and more. Twenty19 also offers online courses and training programs to help students develop their skills and gain industry-specific knowledge. "
        , link = "http://twenty19.com.testednet.com/"),
    Platforms(Title = "Unstop"
        , image ="https://static.theprint.in/wp-content/uploads/2023/02/ANI-20230202131226.jpg"
        , dec ="Unstop serves as a comprehensive portal that bridges the gap between educational institutions, students, and corporate organizations. It offers a wide array of competitive events, internships, job opportunities, hackathons, quizzes, and other skill-building activities."
        , link = "https://unstop.com/internships"),
    Platforms(Title ="DRDO Internships"
        , image = "https://st.adda247.com/https://currentaffairs.adda247.com/wp-content/uploads/multisite/sites/5/2023/01/03100714/rem.jpg"
        , dec = "Scheme of Internship of student to DRDO Labs/Estts is to provide an opportunity and exposure to the would be Graduates/Post Graduates in Engineering/General Sciences to the Research and Development activities carried out by DRDO in state of art technology in the fields relevant to defence sector."
        , link ="https://drdo.gov.in/drdo/student-corner" ),
    Platforms(Title = "Niti Aayog Internship"
        , image ="https://indiashippingnews.com/wp-content/uploads/2023/05/NITI-AAOYOG.jpg" ,
        dec = "Undergraduate/postgraduate students or research scholars enrolled in recognized universities/institutions in India and abroad can apply for the NITI Aayog Internship Scheme. They will work closely with NITI's verticals/divisions/cells. Applicants will have to apply online by filling up the registration form.",
        link = "https://www.niti.gov.in/internship" ),
    Platforms(Title ="DPIIT Internship"
        , image = "https://d8it4huxumps7.cloudfront.net/bites/wp-content/banners/2023/4/644616d6caf19_dpiit_internship_program.jpg",
        dec = "The DPIIT (Department for Promotion of Industry and Internal Trade) internship program is a government initiative in India that provides opportunities for students and young professionals to gain practical experience in various domains related to industry promotion, policy-making, and trade."
        ,link = "https://dpiit.gov.in/internship/internship-scheme.php"),
    Platforms(Title = "ISRO Internship"
        , image = "https://media.licdn.com/dms/image/sync/D4D27AQFgcVrq7_a15Q/articleshare-shrink_800/0/1711266381387?e=2147483647&v=beta&t=HfsFE3DwkwXsjvbu4AJVooYALxz11gDGvhqi3Nb6FcI",
        dec = "Internship opportunity shall be extended for UG/ PG/ PhD students (a Citizen of India) pursuing from a recognized University/ Institution (India/Abroad) in the disciplines of Science/Technology or have completed within six months of the application.\n" +
                "The duration of the Internship work will be a maximum period of 45 days.\n" +
                "The student should possess an aggregate of a minimum of 60% or a CGPA of 6.32 on a scale of 10.",
        link = "https://www.isro.gov.in/InternshipAndProjects.html"),
    Platforms(Title ="NPTEL Internship "
        , image ="https://mc-webpcache.readwhere.in/mcms.php?size=large&in=https://mcmscache.epapr.in/post_images/website_326/post_26407473/full.jpg"
        , dec = "NPTEL provides toppers with the opportunity to gain rich research experiences with faculty from prestigious IITs and IISc.\n" +
                "From 2018 summer onwards, NPTEL has started offering internships to NOC exam toppers with the respective course instructors.\n" +
                "NPTEL is inviting learners from various colleges, universities, and institutes who have topped any of the NPTEL courses to pursue internships under the guidance of faculty from the IITs and IISc"
        , link ="https://nptel.ac.in/internship" ),
    Platforms(Title ="Indian Institute of Remote Sensing Summer Internship",
        image = "https://media.licdn.com/dms/image/C4D16AQHVSwgsbM9g5Q/profile-displaybackgroundimage-shrink_200_800/0/1662319202142?e=2147483647&v=beta&t=X0Eh1uSoSJNV2mB7Tx_aLIEXbtXlqw4rys87WLLVOBs"
        , dec = "The Indian Institute of Remote Sensing (IIRS) offers a summer internship program for students interested in remote sensing, geoinformatics, and related fields. This program allows participants to work on advanced research projects, gain hands-on experience with cutting-edge technology, and collaborate with experts in the field."
        , link = "https://www.iirs.gov.in/externalprojects/internship"),
    Platforms(Title = "CeNSE, IISc Bangalore"
        , image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYRCot0ntvyuHI6pzbYYZtCtq2pI2EAzG05QMYxI5zSr4lQXJ3Wq0VsD5IQCf-oIUyuBM&usqp=CAU"
        , dec = "Starting from 2013, the centre conducts a training program every summer, for promising Undergraduate and Masters students from India and abroad, selected through a rigorous and competitive process. The training is primarily based on the facilities available at CeNSE, and covers a variety of research topics under the broad umbrella of nano science and engineering. The training program will be of 8 -10 weeks duration. The scholarship paid to the eligible candidates would be Rs 5000/month."
        , link ="http://www.cense.iisc.ac.in/content/summer-program" ),
    Platforms(Title = "IIT Goa Summer Research Internship"
        , image = "https://i.ytimg.com/vi/TMCq72Ny1uI/sddefault.jpg"
        , dec = "A summer research internship at an Indian Institute of Technology (IIT) offers undergraduate students the opportunity to engage in advanced research projects under the guidance of esteemed faculty, enhancing their academic and professional skills. These internships, typically lasting 6-8 weeks, provide exposure to cutting-edge research environments and are highly competitive."
        , link = "https://iitgoa.ac.in/summer-internships-2024-at-iit-goa/" ),
    Platforms(Title = "IIT Delhi Summer Research Internship"
        , image = "https://img.etimg.com/thumb/width-1200,height-900,imgsize-54344,resizemode-75,msid-102175915/industry/services/education/iit-delhi-rolls-out-multiple-provisions-including-multiple-entry-and-exit-options-from-courses-in-line-with-nep-2020.jpg"
        , dec = "A summer research internship at an Indian Institute of Technology (IIT) Delhi offers undergraduate students the opportunity to engage in advanced research projects under the guidance of esteemed faculty, enhancing their academic and professional skills. These internships, typically lasting 6-8 weeks, provide exposure to cutting-edge research environments and are highly competitive.",
        link = "https://academics.iitd.ac.in/srf/"),
    Platforms(Title = "IIT Kanpur Summer Research Internship"
        , image ="https://eduadvice.in/media/uploads/blog/IIT-Kanpur1.jpg"
        , dec = "A summer research internship at an Indian Institute of Technology (IIT) Kanpur offers undergraduate students the opportunity to engage in advanced research projects under the guidance of esteemed faculty, enhancing their academic and professional skills. These internships, typically lasting 6-8 weeks, provide exposure to cutting-edge research environments and are highly competitive."
        , link = "https://surge.iitk.ac.in/"),
    Platforms(Title ="IIT Ropar  Summer Research Internship "
        , image = "https://abped-college-dashboard.s3.us-east-2.amazonaws.com/tted/college-backend/college/bcfd47bb-b9e3-4aad-b586-53ff70ff4e54.jpg"
        , dec = "A summer research internship at an Indian Institute of Technology (IIT) Ropar offers undergraduate students the opportunity to engage in advanced research projects under the guidance of esteemed faculty, enhancing their academic and professional skills. These internships, typically lasting 6-8 weeks, provide exposure to cutting-edge research environments and are highly competitive."
        , link = "https://www.iitrpr.ac.in/summer-internship-programme-2024" ),
    Platforms(Title ="IIT Palakkad  Summer Research Internship",
        image = "https://dizagroup.com/wp-content/uploads/2022/10/1664259006069.png",
        dec = "A summer research internship at an Indian Institute of Technology (IIT) offers undergraduate students the opportunity to engage in advanced research projects under the guidance of esteemed faculty, enhancing their academic and professional skills. These internships, typically lasting 6-8 weeks, provide exposure to cutting-edge research environments and are highly competitive.",
        link = "https://sun.iitpkd.ac.in/2024"),
    Platforms(Title = "IIT Madras Summer Research Internship"
        , image = "https://etimg.etb2bimg.com/photo/84997262.cms"
        , dec = "The IITM - Summer Fellowship Programme of two months with stipend is designed to enhance awareness and interest in high quality academic research among young Engineering, Management, Sciences and Humanities students through a goal oriented summer mini-project undertaken at the Indian Institute of Technology Madras."
        , link = "https://sfp.iitm.ac.in/"),
    Platforms(Title ="IIT Mandi Summer Research Internship"
        , image = "https://image.telanganatoday.com/wp-content/uploads/2023/08/iit-mandi_V_jpg--442x260-4g.webp?sw=412&dsz=442x260&iw=412&p=false&r=2.625"
        , dec = "A summer research internship at an Indian Institute of Technology (IIT) offers undergraduate students the opportunity to engage in advanced research projects under the guidance of esteemed faculty, enhancing their academic and professional skills. These internships, typically lasting 6-8 weeks, provide exposure to cutting-edge research environments and are highly competitive."
        , link = "https://iitmandi.ac.in/internships.php"),
    Platforms(Title ="Summer Undergraduate Research Exposure (SURE) "
        ,image = "https://www.jobskar.com/uploads/orgimg/44f3dfba7da1f2eeab129a4241002ac1.jpg"
        , dec = "The Summer Undergraduate Research Exposure (SURE)  program provides undergraduate students with the opportunity to engage in research projects at premier institutions like IITs. This program, typically lasting 6-8 weeks, allows participants to work closely with faculty mentors, gain hands-on research experience, and enhance their academic and professional skills in a rigorous research environment."
        , link = "https://www.iith.ac.in/news/2024/02/15/Summer-Undergraduate-Research-Exposure/"),
    Platforms(Title = "Summer Research Internship Programme IIT Gandhi Nagar"
        , image = "https://resize.indiatvnews.com/en/resize/newbucket/400_-/2020/05/1560778427-vqcivp-iit-gandhinagar-entrance-1589189938.jpg"
        , dec = "The flagship program strives to bring the motivated students from prominent institutions across the country right here on our campus. It will allow undergraduate and master students to participate in the cutting edge research projects; they undergo mentorship by IITGN faculty and get exposure to the state of the art laboratories and instrumentation facilities available on campus."
        , link = "https://srip.iitgn.ac.in/info/"),
    Platforms(Title = "IIT Guwahati"
        , image = "https://akm-img-a-in.tosshub.com/businesstoday/images/story/202301/iit-sixteen_nine.jpg?size=1200:675"
        , dec = "A summer research internship at an Indian Institute of Technology (IIT) offers undergraduate students the opportunity to engage in advanced research projects under the guidance of esteemed faculty, enhancing their academic and professional skills. These internships, typically lasting 6-8 weeks, provide exposure to cutting-edge research environments and are highly competitive."
        , link = "https://www.iitg.ac.in/cse/summerinternship/"),
    Platforms(Title ="IIT Indore"
        , image = "https://media.assettype.com/knocksense%2F2023-07%2F7c18f4de-1f19-4226-a7a6-d61b46ccb504%2Fiit_indore_1604928121.jpg"
        , dec = "A summer research internship at an Indian Institute of Technology (IIT) offers undergraduate students the opportunity to engage in advanced research projects under the guidance of esteemed faculty, enhancing their academic and professional skills. These internships, typically lasting 6-8 weeks, provide exposure to cutting-edge research environments and are highly competitive."
        , link = "https://www.indiascienceandtechnology.gov.in/internships/iit-indore-summer-internship-2024-undergraduate-students"),
    Platforms(Title = "IIT Bhilai "
        , image = "https://hindi.cdn.zeenews.com/hindi/sites/default/files/styles/zm_700x400/public/2023/06/09/1865007-iit-bhilai.jpg?itok=_OtvJYQA"
        , dec = "A summer research internship at an Indian Institute of Technology (IIT) offers undergraduate students the opportunity to engage in advanced research projects under the guidance of esteemed faculty, enhancing their academic and professional skills. These internships, typically lasting 6-8 weeks, provide exposure to cutting-edge research environments and are highly competitive."
        , link = "https://iitbhilai.ac.in/index.php?pid=Adv_intern_1607"),
    Platforms(Title = "Code Clause"
        , image = "https://i.ytimg.com/vi/QBQjzxQTe-c/maxresdefault.jpg"
        , dec ="CodeClause is all about creating opportunities for leadership development, learning, and student engagement of shared interests. They conduct various levels and various tasks at each level. This Internship gave us Challenging Opportunities and real real-world projects. Overall, it was a great learning experience."
        , link = "https://internship.codeclause.com/career"),
    Platforms(Title = "SyncInterns"
        , image = "https://syncinterns.com/wp-content/uploads/2024/02/IMG_20230706_224542.png"
        , dec = "SyncInterns is a nonprofit organization that provides opportunities for students to gain experience in a variety of industries through internships. The internship program is designed to help students develop important skills like communication, collaboration, and problem-solving. Interns work alongside professionals in their field and receive mentorship and training from experienced professionals. "
        , link = "https://syncinterns.com/sync-interns-bootcamp/"),
    Platforms(Title = "Intern Pe"
        , image = "https://media.licdn.com/dms/image/D5612AQGhNEoLHwaT0g/article-cover_image-shrink_720_1280/0/1709890243906?e=2147483647&v=beta&t=VhCS9pH4XbY2yrdJZo3bR_5-OmHHDJLUjtRtZxgj3YE"
        , dec = "Unlock Your Potential with InternPe's Internship Program! Dive into hands-on experiences, gain invaluable skills, and connect with industry leaders. Whether you're a budding engineer, marketer, or designer, InternPe offers tailored opportunities to propel your career forward."
        , link = "https://internpe.in/"),
    Platforms(Title ="Octanet"
        , image = "https://static.ambitionbox.com/assets/v2/images/rs:fit:1280:960:false:false/bG9jYWw6Ly8vbG9nb3Mvb3JpZ2luYWxzL29jdGFuZXQuanBn.png"
        , dec = "An Octanet Internship is a paid and educational internship program offered by Octanet, a global IT solutions provider. The program is designed for highly motivated and intellectually curious students or recent graduates with a strong interest in IT. As an intern, you will gain hands-on experience working on diverse IT projects, as well as access to cutting-edge technologies and resources. "
        , link = "https://octanet.in/projects/"),
    Platforms(Title = "Txon"
        , image = "https://i.ytimg.com/vi/O2c5JNTIp6g/sddefault.jpg"
        , dec = "TXON is a company that specializes in providing innovative technological solutions and training programs. It offers a range of services including software development, IT consulting, and digital transformation. TXON also focuses on educational initiatives, providing internships and project-based learning opportunities for students and professionals."
        , link = "https://txon.in/intern.html"),
    Platforms(Title ="CodeSoft"
        , image = "https://i.ytimg.com/vi/hLkN0Le5MTE/sddefault.jpg"
        , dec = "CodeSoft is a technology company that offers a range of services including software development, IT consulting, and project management. They focus on providing innovative and customized software solutions to meet the unique needs of their clients. Additionally, CodeSoft is known for offering internship programs and training opportunities for students and young professionals, enabling them to gain practical experience and develop their skills in areas such as software development, data analytics, and IT solutions."
        , link = "https://www.codsoft.in/internships" ),
    Platforms(Title = "Lets Grow More"
        , image ="https://media.licdn.com/dms/image/C4E22AQEyBwfr1lBQzQ/feedshare-shrink_800/0/1631063945435?e=2147483647&v=beta&t=limP6rPhZBO6d4vSVrQA7rXZbY3LFTdBZkdiKmzG62g"
        , dec = "Let's Grow More (LGM) is an educational organization that offers a range of internships and project-based learning opportunities aimed at fostering skill development and professional growth. Focused on areas such as software development, data science, artificial intelligence, and more, LGM provides students and young professionals with hands-on experience through real-world projects and tasks. "
        , link = "https://letsgrowmore.in/vip/"),
    Platforms(Title = "Prodigy Infotech"
        , image = "https://media.licdn.com/dms/image/D4D22AQHDXVvdlvWAug/feedshare-shrink_800/0/1687523793458?e=2147483647&v=beta&t=u2UbQxtMDcAUSdBoFBE-ZIp1eJL38T9ROi4R1jusOoA"
        , dec = "Prodgy Infotech is a technology solutions company specializing in software development, IT consulting, and digital transformation services. They offer a range of services including web and mobile application development, cloud computing, and data analytics. Known for their innovative approach and commitment to quality, Prodgy Infotech collaborates with clients across various industries to deliver tailored technology solutions that drive business growth and efficiency."
        , link = "https://prodigyinfotech.dev/"),
    Platforms(Title ="CipherByte Technologies"
        , image ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeIhHCS0mT_YOnTev19uBnw6dXdzikvthG7A&s"
        , dec = "CypherByte Technologies is a dynamic technology company specializing in innovative software solutions, cybersecurity services, and digital transformation. Known for its commitment to excellence and cutting-edge technology, CypherByte Technologies provides a range of services including custom software development, cybersecurity consulting, and IT infrastructure management. The company aims to empower businesses by enhancing their digital capabilities and ensuring robust security measures to protect against cyber threats."
        , link ="https://cipherbytetechnologies.netlify.app/#INTERNSHIPS" ),
    Platforms(Title = "Infolabz"
        , image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVZbfPytkzIBQ5WlPjsNlQSMTuMN38VE9b3g&s"
        , dec = "We strive to provide you with innovative and client-focused solutions. We help our customers modernise their networks in order to improve their market strategy and profitability. We provide excellence while ensuring quality customer service with our expert team, advanced technologies, and seamless processes."
        , link = "https://www.infolabz.in/internship.php"),
    Platforms(Title = "Akash techno Labs"
        , image = "https://media.licdn.com/dms/image/D4D22AQEbc8Sipg9mag/feedshare-shrink_800/0/1686375953811?e=2147483647&v=beta&t=aMs96R2RxISpqGVyfGEgGsdQL1-5YVKjlRNCXGjGDPw"
        , dec = "Akash Technolabs, as a website development company holds a reputed image among our contemporaries. We assure to the best services to our clients for all the work they are dependent on us. Website Development by our firm is completely original and unique. We have professionals working for our clients’ website development projects that are relied upon us. We care for the trust that our clients have in us and so we assure you to keep our quality up to the mark. We work on various website development projects on an international level too."
        , link = "https://www.akashtechnolabs.com/internship.php"),
    Platforms(Title ="TCR Innovation"
        , image = "https://media.licdn.com/dms/image/C560BAQHE6Lhh5erQdg/company-logo_200_200/0/1630638891342?e=2147483647&v=beta&t=6-hyuBbVIFEw5UJlRzswSM1_ATe9AQ-eUH1sjnSKdwk"
        , dec = "TCR Innovation, also known as TCR Advanced Engineering Pvt. Ltd., is a company that specializes in providing innovative engineering solutions and services. Based in India, TCR Innovation focuses on various aspects of engineering, including research, development, and consultancy in sectors such as aerospace, automotive, defense, and industrial automation."
        , link = "https://tcrinnovation.co.in/"),
    Platforms(Title ="Cognifyz"
        , image = "https://i.ytimg.com/vi/Aeqh8DGZTf0/sddefault.jpg"
        , dec = "\n" +
                "Cognifyz is a company known for its innovative approach in the field of cognitive computing and artificial intelligence. Specializing in developing AI-driven solutions, Cognifyz leverages advanced algorithms to analyze and interpret complex data, providing actionable insights for businesses. Their technologies are designed to optimize decision-making processes, improve efficiency, and enhance customer experiences across various industries."
        , link = "https://cognifyz.com/internships/"),
    Platforms(Title ="AsteriscTechnocrat"
        , image = "https://images.jdmagicbox.com/comp/nagpur/f1/0712px712.x712.230226204157.b7f1/catalogue/asterisc-technocrat-pvt-ltd-nagpur-software-companies-gr0b50rtuk.jpg"
        , dec = "Asterisc Technocrat an ISO 9001 : 2015 Internationally Certified & Central India's high rating for Google reviews & most trusted company in nagpur, We are a superb custom software development company in nagpur delivering impressive business IT Solutions and related services to customers across the world. ",
        link ="https://www.technocrat.asterisc.in/internship.html"),
    Platforms(Title = "TechnoHacks EduTech"
        , image = "https://media.licdn.com/dms/image/D4D22AQFvmmBfhBxfvQ/feedshare-shrink_800/0/1697532699528?e=2147483647&v=beta&t=OkwYOGgkSGVlSzRmoQT_CnvuMngOKtkq9i-8JzeED7w"
        , dec = "We provide top-notch IT training and cutting-edge products to help businesses and individuals stay ahead in the ever-evolving tech landscape. Our team of experts is dedicated to helping you achieve your goals and reach your full potential."
        , link = "https://technohacks.co.in/#Internships"),
    Platforms(Title = "TECH-A-INTERN"
        , image = "https://media.licdn.com/dms/image/D5605AQF1WAK2zXWx2g/videocover-low/0/1706692499205?e=2147483647&v=beta&t=2WRQXqWTaGLBpPAG9efRJF_6UoGcOMxIbD2ALiUZqjM"
        , dec = "Tech-A-Intern Is An IT Services And Consultancy Firm Specializing In Innovative Business Solutions. We're Passionate About Technology, Believing In Its Transformative Power. Our Internship Program Reflects Our Commitment To Nurturing The Industry's Future."
        , link = "https://www.techaintern.com/#internship"),
    Platforms(Title = "Digital Bhem"
        , image = "https://digitalbhem.com/wp-content/uploads/2023/04/logo-1.png"
        , dec = "Looking for a digital agency that can take your business to the next level? Look no further than us! With our expertise in all things digital, we’ll help you achieve your goals and stand out from the crowd. Let’s work together and create something amazing!"
        , link = "https://digitalbhem.com/internships/"),
    Platforms(Title = "Smart Internz"
        , image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCmfiVecZTRNtN4hJqdGZxvu_pqlVBj0DIl3zhSNjnBhfRPTN6OrvZ2MmiXhHcLxVDUpw&usqp=CAU"
        , dec = "\n" +
                "Smart Internz is a platform that connects students and professionals with internship opportunities across a wide range of industries and disciplines. It offers a diverse array of internships, including opportunities in technology, business, marketing, design, and more. Smart Internz focuses on providing meaningful learning experiences by partnering with leading companies to offer hands-on projects, mentorship, and networking opportunities."
        , link = "https://smartinternz.com/internships")
)