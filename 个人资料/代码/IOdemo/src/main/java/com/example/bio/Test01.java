package com.example.bio;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.springframework.util.StringUtils;

import java.lang.reflect.Type;
import java.util.*;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-09-18 17:05
 **/
public class Test01 {
    public static final String img_str1 = "[2023/10/07 17:00:50] ppocr DEBUG: Namespace(help='==SUPPRESS==', use_gpu=False, use_xpu=False, use_npu=False, ir_optim=True, use_tensorrt=False, min_subgraph_size=15, precision='fp32', g\n" +
            "pu_mem=500, gpu_id=0, image_dir='ppstructure/docs/table/2.jpg', page_num=0, det_algorithm='DB', det_model_dir='C:\\\\Users\\\\Administrator/.paddleocr/whl\\\\det\\\\ch\\\\ch_PP-OCRv4_det_infer', de\n" +
            "t_limit_side_len=960, det_limit_type='max', det_box_type='quad', det_db_thresh=0.3, det_db_box_thresh=0.6, det_db_unclip_ratio=1.5, max_batch_size=10, use_dilation=False, det_db_score_mod\n" +
            "e='fast', det_east_score_thresh=0.8, det_east_cover_thresh=0.1, det_east_nms_thresh=0.2, det_sast_score_thresh=0.5, det_sast_nms_thresh=0.2, det_pse_thresh=0, det_pse_box_thresh=0.85, det\n" +
            "_pse_min_area=16, det_pse_scale=1, scales=[8, 16, 32], alpha=1.0, beta=1.0, fourier_degree=5, rec_algorithm='SVTR_LCNet', rec_model_dir='C:\\\\Users\\\\Administrator/.paddleocr/whl\\\\rec\\\\ch\\\\\n" +
            "ch_PP-OCRv4_rec_infer', rec_image_inverse=True, rec_image_shape='3, 48, 320', rec_batch_num=6, max_text_length=25, rec_char_dict_path='D:\\\\Program\\\\Anaconda\\\\envs\\\\paddle_env\\\\lib\\\\site-p\n" +
            "ackages\\\\paddleocr\\\\ppocr\\\\utils\\\\ppocr_keys_v1.txt', use_space_char=True, vis_font_path='./doc/fonts/simfang.ttf', drop_score=0.5, e2e_algorithm='PGNet', e2e_model_dir=None, e2e_limit_si\n" +
            "de_len=768, e2e_limit_type='max', e2e_pgnet_score_thresh=0.5, e2e_char_dict_path='./ppocr/utils/ic15_dict.txt', e2e_pgnet_valid_set='totaltext', e2e_pgnet_mode='fast', use_angle_cls=False\n" +
            ", cls_model_dir=None, cls_image_shape='3, 48, 192', label_list=['0', '180'], cls_batch_num=6, cls_thresh=0.9, enable_mkldnn=False, cpu_threads=10, use_pdserving=False, warmup=False, sr_mo\n" +
            "del_dir=None, sr_image_shape='3, 32, 128', sr_batch_num=1, draw_img_save_dir='./inference_results', save_crop_res=False, crop_res_save_dir='./output', use_mp=False, total_process_num=1, p\n" +
            "rocess_id=0, benchmark=False, save_log_path='./log_output/', show_log=True, use_onnx=False, output='./output', table_max_len=488, table_algorithm='TableAttn', table_model_dir='C:\\\\Users\\\\\n" +
            "Administrator/.paddleocr/whl\\\\table\\\\ch_ppstructure_mobile_v2.0_SLANet_infer', merge_no_span_structure=True, table_char_dict_path='D:\\\\Program\\\\Anaconda\\\\envs\\\\paddle_env\\\\lib\\\\site-packa\n" +
            "ges\\\\paddleocr\\\\ppocr\\\\utils\\\\dict\\\\table_structure_dict_ch.txt', layout_model_dir='C:\\\\Users\\\\Administrator/.paddleocr/whl\\\\layout\\\\picodet_lcnet_x1_0_fgd_layout_cdla_infer', layout_dict\n" +
            "_path='D:\\\\Program\\\\Anaconda\\\\envs\\\\paddle_env\\\\lib\\\\site-packages\\\\paddleocr\\\\ppocr\\\\utils\\\\dict\\\\layout_dict\\\\layout_cdla_dict.txt', layout_score_threshold=0.5, layout_nms_threshold=0.5\n" +
            ", kie_algorithm='LayoutXLM', ser_model_dir=None, re_model_dir=None, use_visual_backbone=True, ser_dict_path='../train_data/XFUND/class_list_xfun.txt', ocr_order_method=None, mode='structu\n" +
            "re', image_orientation=True, layout=True, table=True, ocr=True, recovery=False, use_pdf2docx_api=False, invert=False, binarize=False, alphacolor=(255, 255, 255), lang='ch', det=True, rec=\n" +
            "True, type='structure', ocr_version='PP-OCRv4', structure_version='PP-StructureV2')\n";


    public static final String table_str1 = "[2023/10/07 17:13:53] ppocr DEBUG: Namespace(help='==SUPPRESS==', use_gpu=False, use_xpu=False, use_npu=False, ir_optim=True, use_tensorrt=False, min_subgraph_size=15, precision='fp32', gpu_mem=500, gpu_id=0, image_dir=None, page_num=0, det_algorithm='DB', det_model_dir='C:\\\\Users\\\\Administrator/.paddleocr/whl\\\\det\\\\ch\\\\ch_PP-OCRv4_det_infer', det_limit_side_len=960, det_limit_type='max', det_box_type='quad', det_db_thresh=0.3, det_db_box_thresh=0.6, det_db_unclip_ratio=1.5, max_batch_size=10, use_dilation=False, det_db_score_mode='fast', det_east_score_thresh=0.8, det_east_cover_thresh=0.1, det_east_nms_thresh=0.2, det_sast_score_thresh=0.5, det_sast_nms_thresh=0.2, det_pse_thresh=0, det_pse_box_thresh=0.85, det_pse_min_area=16, det_pse_scale=1, scales=[8, 16, 32], alpha=1.0, beta=1.0, fourier_degree=5, rec_algorithm='SVTR_LCNet', rec_model_dir='C:\\\\Users\\\\Administrator/.paddleocr/whl\\\\rec\\\\ch\\\\ch_PP-OCRv4_rec_infer', rec_image_inverse=True, rec_image_shape='3, 48, 320', rec_batch_num=6, max_text_length=25, rec_char_dict_path='E:\\\\gitRepository\\\\newPaddleOCR\\\\PaddleOCR\\\\ppocr\\\\utils\\\\ppocr_keys_v1.txt', use_space_char=True, vis_font_path='./doc/fonts/simfang.ttf', drop_score=0.5, e2e_algorithm='PGNet', e2e_model_dir=None, e2e_limit_side_len=768, e2e_limit_type='max', e2e_pgnet_score_thresh=0.5, e2e_char_dict_path='./ppocr/utils/ic15_dict.txt', e2e_pgnet_valid_set='totaltext', e2e_pgnet_mode='fast', use_angle_cls=False, cls_model_dir=None, cls_image_shape='3, 48, 192', label_list=['0', '180'], cls_batch_num=6, cls_thresh=0.9, enable_mkldnn=False, cpu_threads=10, use_pdserving=False, warmup=False, sr_model_dir=None, sr_image_shape='3, 32, 128', sr_batch_num=1, draw_img_save_dir='./inference_results', save_crop_res=False, crop_res_save_dir='./output', use_mp=False, total_process_num=1, process_id=0, benchmark=False, save_log_path='./log_output/', show_log=True, use_onnx=False, output='./output', table_max_len=488, table_algorithm='TableAttn', table_model_dir='C:\\\\Users\\\\Administrator/.paddleocr/whl\\\\table\\\\ch_ppstructure_mobile_v2.0_SLANet_infer', merge_no_span_structure=True, table_char_dict_path='E:\\\\gitRepository\\\\newPaddleOCR\\\\PaddleOCR\\\\ppocr\\\\utils\\\\dict\\\\table_structure_dict_ch.txt', layout_model_dir='C:\\\\Users\\\\Administrator/.paddleocr/whl\\\\layout\\\\picodet_lcnet_x1_0_fgd_layout_cdla_infer', layout_dict_path='E:\\\\gitRepository\\\\newPaddleOCR\\\\PaddleOCR\\\\ppocr\\\\utils\\\\dict\\\\layout_dict\\\\layout_cdla_dict.txt', layout_score_threshold=0.5, layout_nms_threshold=0.5, kie_algorithm='LayoutXLM', ser_model_dir=None, re_model_dir=None, use_visual_backbone=True, ser_dict_path='../train_data/XFUND/class_list_xfun.txt', ocr_order_method=None, mode='structure', image_orientation=True, layout=True, table=True, ocr=True, recovery=False, use_pdf2docx_api=False, invert=False, binarize=False, alphacolor=(255, 255, 255), lang='ch', det=True, rec=True, type='structure', ocr_version='PP-OCRv4', structure_version='PP-StructureV2')\n";



    public static void main(String[] args) {
        Map<String,String>  imgDatas = getDatas(img_str1);
        Map<String,String>  tableDatas = getDatas(table_str1);
        System.out.println("==================");
        sameKeyDiffVal(imgDatas,tableDatas);
        //bianl(imgDatas);
    }



    //  输出单个
    public static void bianl(Map<String,String>  map){
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
            System.out.println(String.format("%25s", key)+"："+value);
        }
    }

    //比较相同的key值  但是value不同
    public static void sameKeyDiffVal(Map<String,String>  imgDatas,Map<String,String>  tableDatas){

        //  比较两个  相同的key 不同的val
        for (Map.Entry<String, String> entry1 : imgDatas.entrySet()) {
            String key = entry1.getKey();
            String value = entry1.getValue();
            //然后 找个 不同的value
            String s = tableDatas.get(key);
            // 不空 并且 不相等
            if(Objects.nonNull(s)&&(!Objects.equals(s,value))){
                System.out.println( String.format("%25s", key)+"："+value+"--------------"+s);
            }
        }


    }


    public static Map<String,String>  getDatas(String str1){
        Map<String,String>  result = new HashMap<>();
        //  用括号 去替换
        //找到 第一个 和  最后一个
        int firstIndex = str1.indexOf("(");
        int lastIndex = str1.lastIndexOf(")");
        // 然后进行切割
        String str1Temp = str1.substring(firstIndex + 1, lastIndex) .replace("\n", "");
        // 然后用逗号进行切割
        String[] strs = str1Temp.split(",");
        //然后对每一个进行输出
        for (String str : strs) {
            // 然后进行切割
            int index = str.indexOf("=");
            if(index>0){
                result.put(str.substring(0,index).trim(),str.substring(index+1).trim());
            }
        }
        return result;
    }
}
