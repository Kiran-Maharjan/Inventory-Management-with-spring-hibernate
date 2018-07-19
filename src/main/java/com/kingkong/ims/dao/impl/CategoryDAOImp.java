/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kingkong.ims.dao.impl;

import com.kingkong.ims.dao.CategoryDAO;
import com.kingkong.ims.entity.Category;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kiran
 */

@Repository(value="categoryDAO")
public class CategoryDAOImp extends GenericDAOImpl<Category>implements CategoryDAO{
    
    
}
