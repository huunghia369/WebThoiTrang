package management.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import management.dao.IAprioriDao;

import management.entity.Ctpd;
import management.entity.Mathang;
import management.entity.Phieudat;

//import javax.management.loading.PrivateClassLoader;

@Component
public class Apriori {

	@Autowired
	private IAprioriDao aprioriDao;

	private static int numTransactions = 0;
	private static int minSup = 3;
	private static double maxConfidence = 65.0;
	private static int maxSize = 1;
	private static int sizeCustomer = 0;
	private static int sizeAll = 0;

	public List<Mathang> Apriori(int makh) {
//        Integer kiemtra=hoaDonService.getLaySP_KIEMTRAHD(masothue);
//        if (kiemtra==0) {
//			List<Mathang> mathangs=new ArrayList<Mathang>();
//			return null;
//		}
		List<Ctpd> listcthd = aprioriDao.getLayDSCTHD(makh);
		List<Phieudat> listhoadon = aprioriDao.getLayDSHD(makh);
		List<Mathang> listmathangAll = aprioriDao.getLayDSSP();
		List<Mathang> listmathangBuy = aprioriDao.getLayDSSPDAMUA(makh);

		
		String data[][] = new String[200][200];

		String frequentItemSet[][] = new String[1000][1000];
		int Location[] = new int[1000];
		String itemHistory[] = new String[1000];
		String itemAll[] = new String[1000];
//		String itemAll[] = new String[100];
		List<String> finaly = new ArrayList<String>();
		LoadProductAll(itemAll, listmathangAll);
		LoadProductCustomer(itemHistory, listmathangBuy);
		// LoadProductCustomer(itemHistory, listmathangAll);
		LOADDATA(listhoadon, listcthd, data);
		foundFrequentItemSet(data, frequentItemSet, Location, itemAll);
		finaly= foundLawDetermination(data, frequentItemSet, itemHistory,0.6);
//		System.out.println(finaly.size());
//		for (String s : finaly)
//			System.out.println(s);
		// System.out.println("Phong");
//		for(int i = 0; i < 100; i++)
//		{
//			if(frequentItemSet[i][0] == null) break;
//			for (int j  = 0; j < 100; j++) {
//				if(frequentItemSet[i][j] == null)
//					break;
//				System.out.println(frequentItemSet[i][j]);
//			}
//			System.out.println("Phong");
//		}

		List<Mathang> listmathang = new ArrayList<Mathang>();
		List<Double> avgList = new ArrayList<Double>();
		for (int i = 0; i < sizeCustomer; i++) {
			Double danhgia = aprioriDao.getLAYDANHGIA(Integer.parseInt(itemHistory[i]));
			avgList.add(danhgia);
		}
		bubbleSort1(itemHistory, avgList);
		if (finaly.size() > 1) {
			avgList.clear();
			for (int i = 0; i < finaly.size(); i++) {
				Double danhgia = aprioriDao.getLAYDANHGIA(Integer.parseInt(finaly.get(i)));
				avgList.add(danhgia);
			}
			bubbleSort(finaly, avgList);
			int dem = 0;
			if (finaly.size() > 5) {
				for (int i = 0; i < 5; i++)
				// goi sp
				{
					Mathang mathang = aprioriDao.getMHById(Integer.parseInt(finaly.get(i)));
					listmathang.add(mathang);
				}
			} else {
				for (int i = 0; i < finaly.size(); i++)
				// goi sp
				{
//					dem++;
					Mathang mathang = aprioriDao.getMHById(Integer.parseInt(finaly.get(i)));
					listmathang.add(mathang);
				}
				if (sizeCustomer > 5 - finaly.size())
					for (int i = finaly.size(); i < 5; i++) {
						Mathang mathang = aprioriDao.getMHById(Integer.parseInt(itemHistory[i]));
						listmathang.add(mathang);
						dem++;
					}
				else {
					for (int i = finaly.size(); i < sizeCustomer; i++) {
						Mathang mathang = aprioriDao.getMHById(Integer.parseInt(itemHistory[i]));
						listmathang.add(mathang);
						dem++;
					}
				}
			}
		} else {
			if (finaly.size() == 1) {
				String cleanedString = finaly.get(0).trim().replace(",", "");

				Mathang mathang = aprioriDao.getMHById(Integer.parseInt(cleanedString));
				listmathang.add(mathang);
				if (sizeCustomer > 4)
					for (int i = 0; i < 4; i++) {
						mathang = aprioriDao.getMHById(Integer.parseInt(itemHistory[i]));
						listmathang.add(mathang);
					}
				else
					for (int i = 0; i < sizeCustomer; i++) {
						mathang = aprioriDao.getMHById(Integer.parseInt(itemHistory[i]));
						listmathang.add(mathang);
					}
			} else {
				if (sizeCustomer > 5)
					for (int i = 0; i < 5; i++) {
						Mathang mathang = aprioriDao.getMHById(Integer.parseInt(itemHistory[i]));
						listmathang.add(mathang);
					}
				else
					for (int i = 0; i < sizeCustomer; i++) {
						Mathang mathang = aprioriDao.getMHById(Integer.parseInt(itemHistory[i]));
						listmathang.add(mathang);
					}
			}
		}
//		System.out.println("In list mat hang");

//		for(Mathang mathang : listmathang) {
//		System.out.println(mathang.getMamh());
//		}
//		System.out.println("ket thuc list mat hang");
		return listmathang;

	}

	// Lấy danh sách các sản phẩm đã mua của all
	public void LoadProductAll(String itemAll[], List<Mathang> mh) {
		int i = 0;
		for (Mathang m : mh) {
			itemAll[i] = m.getMamh() + "";
			i++;
		}
		sizeAll = i;
	}

	// Lấy danh sách sản phẩm mà khách hàng mua
	public void LoadProductCustomer(String itemHistory[], List<Mathang> mh) {
		int i = 0;
		for (Mathang m : mh) {
			itemHistory[i] = m.getMamh() + "";
			i++;
		}
		sizeCustomer = i;
	}

//	@Query(value = "CALL SP_LAYDSHD(:masothue)", nativeQuery = true)
	public void LOADDATA(List<Phieudat> HD, List<Ctpd> cthd, String data[][]) {
		int i = 0, j = 0;
		numTransactions = HD.size();
		int max = 1;
		for (Phieudat hd : HD) {
			data[i][j] = hd.getMapd() + "";
			j++;
			for (Ctpd ct : cthd) {
				if (ct.getPhieudat().getMapd() == hd.getMapd()) {
					data[i][j] = ct.getId().getMamh() + "";
					j++;
				}
			}
			if (j > max)
				max = j;
			j = 0;
			i++;
		}
		maxSize = max;
	}

	// ok
	// Tìm tập phổ biến

	public static void foundFrequentItemSet(String data[][], String frequentItemSet[][], int Location[],
			String itemAll[]) {
		int colums = 0;
		int rows = 0;

		List<String> frequentTmp = new ArrayList<String>();

		for (int i = 0; i < itemAll.length; i++) {
			String tmp = itemAll[i];
			if( tmp==null) break;
			int count = 0;
			for (int j = 0; j < numTransactions; j++) {
				for (int k = 1; k < maxSize; k++) {
					if (tmp.equals(data[j][k])) {
						count++;
						break;
					}
				}
			}

			if (count >= 2) {
				frequentItemSet[rows][colums] = tmp;
				Location[rows] = count;
				rows++;
				frequentTmp.add(tmp);
			}
		}

		while (!frequentTmp.isEmpty()) {
			List<String> newFrequentTmp = new ArrayList<String>();

			for (int t = 0; t < frequentTmp.size(); t++) {
				for (int p = t; p < frequentTmp.size(); p++) {
					int count = 0;

					for (int i = 0; i < numTransactions; i++) {
						boolean allFound = true;

						for (int k = 0; k < colums; k++) {
							boolean found = false;
							for (int j = 1; j < maxSize; j++) {
								if (frequentItemSet[rows - 1][k].equals(data[i][j])) {
									found = true;
									break;
								}
							}
							if (!found) {
								allFound = false;
								break;
							}
						}

						if (allFound) {
							for (int j = 1; j < maxSize; j++) {
								if (frequentTmp.get(p).equals(data[i][j])) {
									count++;
									break;
								}
							}
						}
					}

					if (count >= 2 && frequentTmp.get(p) != null) {
					    if (rows < frequentItemSet.length) {
					        for (int i = 0; i < colums + 1; i++) {
					            frequentItemSet[rows][i] = (i == colums) ? frequentTmp.get(p) : frequentItemSet[rows - 1][i];
					        }
					        Location[rows] = count;
					        rows++;
					        newFrequentTmp.add(frequentTmp.get(p));
					    } else {
					        // Xử lý trường hợp giới hạn của mảng đã vượt quá
					        // Có thể tạo một mảng mới hoặc thay đổi kích thước của mảng hiện tại tùy thuộc vào nhu cầu của bạn.
					    }
					}


				}
			}

			frequentTmp = newFrequentTmp;
			colums++;
		}
		
		for( String[] x:frequentItemSet)
		{
			 System.out.println(x[0]);
		}
		System.out.println("k");
		
	}

	// ok
	public List<String> foundLawDetermination(String data[][], String frequentItemSet[][], String itemHistory[], double minConfidence) {
	    Set<String> finaly = new HashSet<>();

	    for (int i = 0; i < frequentItemSet.length; i++) {
	        for (int j = 0; j < frequentItemSet[i].length && frequentItemSet[i][j] != null; j++) {
	            // Tìm tất cả các luật kết hợp với frequentItemSet[i][j] như là "X" (antecedent)
	            String antecedent = frequentItemSet[i][j];
	            
	            for (int k = 0; k < frequentItemSet[i].length; k++) {
	                if (k != j && frequentItemSet[k][j] != null) {
	                    String consequent = frequentItemSet[k][j];
	                    
	                    double supportAntecedent = calculateSupport(antecedent, itemHistory);
	                    double supportConsequent = calculateSupport(consequent, itemHistory);
	                    double supportBoth = calculateSupportForBoth(antecedent, consequent, itemHistory);

	                    double confidence = supportBoth / supportAntecedent;

	                    if (confidence >= minConfidence) {
	                        String rule = antecedent + " -> " + consequent + " (Confidence: " + confidence + ")";
	                       
	                        finaly.add(consequent);
	                    }
	                }
	            }
	        }
	    }
	    
	    
	    return new ArrayList<>(finaly);
	}

	public static double calculateSupport(String item, String itemHistory[]) {
	    int count = 0;
	    for (String historyItem : itemHistory) {
	        if (historyItem != null && historyItem.equals(item)) {
	            count++;
	        }
	    }
	    return (double) count / itemHistory.length;
	}

	public static double calculateSupportForBoth(String antecedent, String consequent, String itemHistory[]) {
	    int count = 0;
	    boolean foundAntecedent = false;
	    for (String historyItem : itemHistory) {
	        if (historyItem != null) {
	            if (historyItem.equals(antecedent)) {
	                foundAntecedent = true;
	            } else if (foundAntecedent && historyItem.equals(consequent)) {
	                count++;
	            }
	        }
	    }
	    return (double) count / itemHistory.length;
	}

	// Tính confidence
	// 1: add 0: duyệt dòng mới
	public static int checkElement(String data[][], int n, String confidence[], int dangXet) {
		int count = 0;
//		System.out.println(dangXet);
		double maxCon = 60.0;
//		boolean revise = true;
		// Duyệt kiểm tra với vt là một mặt hàng có xác định được không?
//		for(int i = 0; i < n; i++)
//			System.out.print(confidence[i]);
//		System.out.println(" phong");
		for (int i = 0; i < n; i++) {
			count = 0;
			for (int j = 0; j < numTransactions; j++)
				for (int k = 0; k < maxSize; k++)
					if (confidence[i].equals(data[j][k])) {
						count++;
						break;
					}

			double con = (dangXet * 1.0 / count) * 100;
//			System.out.println(count);
			if (con > maxCon || con == maxCon) {
				return 1;
//				revise = false;
			}
		}
		if (n == 1)
			return 0;
		// chưa xác định được duyệt tiếp
		int columsXet = 1;
		int dem = 0;

		// Kiểm tra đoạn này nếu sảy ra lỗi
		// Duyệt từng phần tử.
		for (int i = 0; i < n; i++) {
			// Duyệt theo dòng
			for (int k = 0; k < numTransactions; k++) {
				dem = 0;
				// Kiểm tra a có phải là con của b không?
				for (int j = i + 1; j < columsXet + 1; j++) {
					for (int p = 0; p < maxSize; p++)
						if (data[k][p].equals(confidence[j])) {
							dem++;
							// p = 0;
							break;
						}
					for (int p = 0; p < maxSize; p++)
						if (data[k][p].equals(confidence[i])) {
							dem++;
							break;
						}
				}
				if (dem == columsXet + 1)
					count++;
			}
			double con = (dangXet * 1.0 / count) * 100;
			if (con > maxCon || con == maxCon)
				return 1;
			columsXet++;
			// Nếu chưa xét theo phẩn tử đầu thì tiếp tục duyệt tiếp.
			if (columsXet < n)
				i--;
		}
		return 0;
	}

	// 0: ko ton tai, 1: co ton tai
	public static int CheckFrequent(List<String> S, String s) {
		if (S.size() == 0)
			return 0;
		for (String tmp : S) {
			if (s.equals(tmp))
				return 1;
		}
		return 0;

	}

	public void bubbleSort(List<String> finaly, List<Double> avg) {
		Double tmp1;
		String tmp;
		int i, j;
		boolean swapped;
		for (i = 0; i < finaly.size() - 1; i++) {
			swapped = false;
			for (j = 0; j < finaly.size() - 1 - i; j++)
				if (avg.get(j) < avg.get(j + 1)) {
					tmp1 = avg.get(j);
					tmp = finaly.get(j);
					avg.set(j, avg.get(j + 1));
					avg.set(j + 1, tmp1);
					finaly.set(j, finaly.get(j + 1));
					finaly.set(j + 1, tmp);
					swapped = true;
				}
			if (!swapped)
				break;
		}

	}

	public void bubbleSort1(String itemHistory[], List<Double> avg) {
		Double tmp1;
		String tmp;
		int i, j;
		boolean swapped;
		if (sizeCustomer == 0)
			return;
		for (i = 0; i < sizeCustomer - 1; i++) {
			swapped = false;
			for (j = 0; j < sizeCustomer - 1 - i; j++)
				if (avg.get(j) < avg.get(j + 1)) {
					tmp1 = avg.get(j);
					tmp = itemHistory[j];
					avg.set(j, avg.get(j + 1));
					avg.set(j + 1, tmp1);
					itemHistory[j] = itemHistory[j + 1];
					itemHistory[j + 1] = tmp;
					swapped = true;
				}
			if (!swapped)
				break;
		}
	}
}
