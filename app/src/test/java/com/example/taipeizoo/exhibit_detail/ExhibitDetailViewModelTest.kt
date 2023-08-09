package com.example.taipeizoo.exhibit_detail

import com.example.taipeizoo.exhibits_detail.ExhibitDetailViewModel
import com.example.taipeizoo.model.GetAnimalsResponse
import com.example.taipeizoo.model.GetExhibitsResponse
import com.example.taipeizoo.repository.ZooRepositoryInterface
import com.google.gson.Gson
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import retrofit2.Response

@RunWith(RobolectricTestRunner::class)
@ExperimentalCoroutinesApi
class ExhibitDetailViewModelTest {
    private lateinit var viewModel: ExhibitDetailViewModel
    private val zooRepository = Mockito.mock(ZooRepositoryInterface::class.java)


    @Before
    fun setup() {
        viewModel = ExhibitDetailViewModel(zooRepository)
    }

    @Test
    fun testGetAnimalSuccess() = runTest((StandardTestDispatcher())) {

        val json =
            "{\"result\":{\"limit\":20,\"offset\":0,\"count\":272,\"sort\":\"\",\"results\":[{\"_id\":1,\"_importdate\":{\"date\":\"2022-12-23 14:05:14.668579\",\"timezone_type\":3,\"timezone\":\"Asia\\/Taipei\"},\"a_name_ch\":\"大貓熊\",\"a_summary\":\"\",\"a_keywords\":\"\",\"a_alsoknown\":\"貓熊、熊貓\",\"a_geo\":\"MULTIPOINT ((121.5831587 24.9971109))\",\"a_location\":\"新光特展館（大貓熊館）\",\"a_poigroup\":\"\",\"a_name_en\":\"Giant Panda\",\"a_name_latin\":\"Ailuropoda melanoleuca\",\"a_phylum\":\"脊索動物門\",\"a_class\":\"哺乳綱\",\"a_order\":\"食肉目\",\"a_family\":\"熊科\",\"a_conservation\":\"易危(VU)\",\"a_distribution\":\"目前僅存於中國四川、甘肅和陜西三省境內。\",\"a_habitat\":\"海拔2600-3,000公尺的高山中，會因季節的變化而改變其居住的海拔高度，一般在乾淨的活水源和竹林發育良好的地區活動。\",\"a_feature\":\"1、 成熊身長約為120-180公分，體重約80-120公斤，幼熊出生時體長約10公分，體重約僅有150~200公克。\\n 2、 具有強壯有力的四肢：後腳內八字撇，有利於在密林中走動時撥開竹子。\\n 3、 腕骨特化成的偽拇指(不具備關節)，使得牠們能俐落地取食竹子。\\n 4、 掌心覆有毛，使得大貓熊能夠在寒冷的雪地上行走。\\n 5、大貓熊身體顏色主要為黑白兩色。耳朵、眼斑、鼻頭、肩背部和四肢為黑色，其餘部位為白色。相對比例較小的黑色耳朵有減少熱量散失的功能。\",\"a_behavior\":\"1、獨居的動物，除了交配季節或雌性的育幼時期，牠們都是獨自居住的。\\r\\n2、最活躍的時間在早晨和黃昏，但竹子所含熱量低，為減少能量的消耗，牠們每天的睡眠時間約10小時，剩餘時間則大多在覓食和進食。\",\"a_diet\":\"大貓熊以竹為主食(佔日糧中大約99%)\",\"a_crisis\":\"過去大貓熊棲息地裡的竹林竹種較為單一，1983年曾發生棲地內箭竹週期性大規模開花枯死而有大貓熊餓死的情形，竹林一旦開花，須再經多年後才能恢復舊觀。另外大貓熊棲息地的破碎化，使得牠們無法遷徙至其他有竹子的地方，加劇了這個原是林地自然演替的危害。也因棲地破碎化，部分種群因數量規模小，基因的窄化以及無法延續也成為另一嚴重問題。\",\"a_interpretation\":\"\",\"a_theme_name\":\"YA!大貓熊-臺北大貓熊保育網\",\"a_theme_url\":\"http:\\/\\/newweb.zoo.gov.tw\\/panda\\/\",\"a_adopt\":\"\",\"a_code\":\"Panda\",\"a_pic01_alt\":\"大貓熊「團團」和「圓圓」\",\"a_pic01_url\":\"http:\\/\\/www.zoo.gov.tw\\/iTAP\\/03_Animals\\/PandaHouse\\/Panda_Pic01.jpg\",\"a_pic02_alt\":\"「圓仔」跟媽媽互動\",\"a_pic02_url\":\"http:\\/\\/www.zoo.gov.tw\\/iTAP\\/03_Animals\\/PandaHouse\\/Panda_Pic02.jpg\",\"a_pic03_alt\":\"大貓熊「圓仔」\",\"a_pic03_url\":\"http:\\/\\/www.zoo.gov.tw\\/iTAP\\/03_Animals\\/PandaHouse\\/Panda_Pic03.jpg\",\"a_pic04_alt\":\"大貓熊「團團」和「圓圓」\",\"a_pic04_url\":\"http:\\/\\/www.zoo.gov.tw\\/iTAP\\/03_Animals\\/PandaHouse\\/Panda_Pic04.jpg\",\"a_pdf01_alt\":\"「遇見大貓熊」學習單(4.2MB)\",\"a_pdf01_url\":\"http:\\/\\/www.zoo.gov.tw\\/iTAP\\/03_Animals\\/PandaHouse\\/Panda_PDF01.pdf\",\"a_pdf02_alt\":\"「遇見大貓熊」解答(1.18MB)\",\"a_pdf02_url\":\"http:\\/\\/www.zoo.gov.tw\\/iTAP\\/03_Animals\\/PandaHouse\\/Panda_PDF02.pdf\",\"a_voice01_alt\":\"雌大貓熊咩叫聲\",\"a_voice01_url\":\"http:\\/\\/mediasys.taipei.gov.tw\\/tcg\\/service\\/KMStorage\\/355\\/894E598B-8A9F-BAA8-206D-8DF52A8C5763\\/Panda_Voice01.mp3\",\"a_voice02_alt\":\"雌雄大貓熊交配時的叫聲\",\"a_voice02_url\":\"http:\\/\\/mediasys.taipei.gov.tw\\/tcg\\/service\\/KMStorage\\/355\\/3FAC21EE-A863-6E2C-BF12-4E6FEF67BDE\\/Panda_Voice02.mp3\",\"a_voice03_alt\":\"山豬老大ABC第13集Bears\",\"a_voice03_url\":\"http:\\/\\/mediasys.taipei.gov.tw\\/tcg\\/service\\/KMStorage\\/355\\/ADB04074-6156-5C7C-1630-B4E88BAD5147\\/Panda_Voice03.mp3\",\"a_vedio_url\":\"http:\\/\\/www.youtube.com\\/playlist?list=PLWYak5Af5-DvboTzxQYeg7aKYA9UHYwSf\",\"a_update\":\"########\",\"a_cid\":\"1\"},{\"_id\":2,\"_importdate\":{\"date\":\"2022-12-23 14:05:14.684926\",\"timezone_type\":3,\"timezone\":\"Asia\\/Taipei\"},\"a_name_ch\":\"國王企鵝\",\"a_summary\":\"\",\"a_keywords\":\"企鵝；國王企鵝\",\"a_alsoknown\":\"\",\"a_geo\":\"MULTIPOINT ((121.5907654 24.9931338))\",\"a_location\":\"企鵝館\",\"a_poigroup\":\"\",\"a_name_en\":\"King Penguin\",\"a_name_latin\":\"Aptenodytes patagonicus\",\"a_phylum\":\"脊索動物門\",\"a_class\":\"鳥綱\",\"a_order\":\"企鵝目\",\"a_family\":\"企鵝科\",\"a_conservation\":\"暫無危機 LC\",\"a_distribution\":\"次南極區。涵蓋南美福克蘭群島、喬治亞群島、南非南方海域及紐西蘭南方海域。\",\"a_habitat\":\"\",\"a_feature\":\"1、 國王企鵝是全世界體型第二大的企鵝(僅次於帝王企鵝)，嘴喙長、耳羽顏色偏橘，有一圈黑邊框，圖案類似水滴形。\\r\\n 2、 喉嚨至前胸部位為美麗的金黃色。\\r\\n 3、 體長大約95公分(測量企鵝的體長，是由嘴至尾拉長)。體重大約12～15Kg。在圈養環境下平均壽命約15至20年。\",\"a_behavior\":\"1、國王企鵝在圈養環境下平均壽命約15-20年。\\r\\n 2、國王企鵝繁殖期會群聚在一起，繁殖期期間會有領域性，每對領域的範圍約1平方公尺。不築巢，每窩下一個蛋，由雌雄輪流孵蛋，孵化期平均約56天。雛鳥孵出時幾乎全裸，帶有一些短絨羽，第一次的絨羽淺灰或褐色，第二次則轉為暗褐色，約40天大加入幼鳥群，約10-13個月羽翼豐滿。約5-7歲達到性成熟。\\r\\n 3、國王企鵝野外族群估計超過兩百萬隻，呈增加的趨勢(國際自然保育聯盟IUCN於2008年評估)。\",\"a_diet\":\"主要以魚維生，野外的國王企鵝特別喜歡吃小型的燈籠魚科(Myctophidae)的魚類，也會吃頭足類(cephalopods)如魷魚(Moroteuthis)。\",\"a_crisis\":\"\",\"a_interpretation\":\"\",\"a_theme_name\":\"\",\"a_theme_url\":\"\",\"a_adopt\":\"\",\"a_code\":\"KingPenguin\",\"a_pic01_alt\":\"國王企鵝\",\"a_pic01_url\":\"http:\\/\\/www.zoo.gov.tw\\/iTAP\\/03_Animals\\/PenguinHouse\\/KingPenguin\\/KingPenguin_Pic01.jpg\",\"a_pic02_alt\":\"國王企鵝\",\"a_pic02_url\":\"http:\\/\\/www.zoo.gov.tw\\/iTAP\\/03_Animals\\/PenguinHouse\\/KingPenguin\\/KingPenguin_Pic02.jpg\",\"a_pic03_alt\":\"國王企鵝\",\"a_pic03_url\":\"http:\\/\\/www.zoo.gov.tw\\/iTAP\\/03_Animals\\/PenguinHouse\\/KingPenguin\\/KingPenguin_Pic03.jpg\",\"a_pic04_alt\":\"國王企鵝\",\"a_pic04_url\":\"http:\\/\\/www.zoo.gov.tw\\/iTAP\\/03_Animals\\/PenguinHouse\\/KingPenguin\\/KingPenguin_Pic04.jpg\",\"a_pdf01_alt\":\"\",\"a_pdf01_url\":\"\",\"a_pdf02_alt\":\"\",\"a_pdf02_url\":\"\",\"a_voice01_alt\":\"\",\"a_voice01_url\":\"\",\"a_voice02_alt\":\"\",\"a_voice02_url\":\"\",\"a_voice03_alt\":\"\",\"a_voice03_url\":\"\",\"a_vedio_url\":\"https:\\/\\/www.youtube.com\\/playlist?list=PLWYak5Af5-DuSoWNgHVIi8vH8AlN6Rzg4\",\"a_update\":\"2017\\/9\\/29\",\"a_cid\":\"2\"}]}}"
        val gson = Gson()

        val getAnimalsResponse = gson.fromJson(json, GetAnimalsResponse::class.java)

        val response = Response.success(getAnimalsResponse)
        Mockito.`when`(zooRepository.getAnimals()).thenReturn(response)

        viewModel.getAnimals()

        TestCase.assertTrue(viewModel.isLoading.value == false)
        TestCase.assertNotNull(viewModel.data.value)

    }

    @Test
    fun testGetAnimalFailure() = runTest((StandardTestDispatcher())) {

        val errorBody = ResponseBody.create(MediaType.parse("application/json"), "{\"error\": \"Some error message\"}")
        val response = Response.error<GetExhibitsResponse>(404, errorBody)

        Mockito.`when`(zooRepository.getExhibits()).thenReturn(response)

        viewModel.getAnimals()

        TestCase.assertTrue(viewModel.isLoading.value == false)
        TestCase.assertNull(viewModel.data.value)
    }

}