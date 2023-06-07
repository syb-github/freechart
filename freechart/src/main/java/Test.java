//引入jfreechart的jar包
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        //使用jfreechart生成柱状图,并存成图片到本地
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "北京", "苹果");
        dataset.addValue(200, "北京", "香蕉");
        dataset.addValue(300, "北京", "橘子");
        dataset.addValue(400, "北京", "梨子");
        dataset.addValue(500, "北京", "葡萄");
        dataset.addValue(600, "北京", "草莓");
        dataset.addValue(700, "北京", "西瓜");
        dataset.addValue(800, "北京", "芒果");
        dataset.addValue(900, "北京", "榴莲");

        Font font = new Font("Microsoft YaHei", Font.PLAIN, 12);
        ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
        StandardChartTheme theme = (StandardChartTheme)ChartFactory.getChartTheme();
        theme.setExtraLargeFont(font);
        theme.setLargeFont(font);
        theme.setRegularFont(font);
        theme.setSmallFont(font);
        //生成柱状图
        JFreeChart chart = ChartFactory.createBarChart("水果产量图", "水果", "产量", dataset);
        //将柱状图保存到本地
        try {
            BufferedImage bufferedImage = chart.createBufferedImage(800, 600);
            File file = new File("C:\\test.png");
            javax.imageio.ImageIO.write(bufferedImage, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
